package com.wuhan.collecting.appoint;

import com.wuhan.collecting.mapper.UserMapper;
import com.wuhan.collecting.model.User;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserAppoint {

    @Autowired
    UserMapper userMapper;

    public SystemResult checkUserLogin(String phone, String password) {
        if(StringUtils.isEmpty(phone) || phone.length() != 11) {
            return new SystemResult(101, "用户名长度应为11");
        }

        if(StringUtils.isEmpty(password) || password.length() < 6 || password.length() > 11) {
            return new SystemResult(102, "密码长度应为6~11");
        }

        User user = userMapper.get(phone);

        if (user == null) {
            return new SystemResult(103, "用户名不存在");
        }

        if (user.getStatus() == 0) {
            return new SystemResult(104, "用户已被禁用");
        }

        if (!user.getPassword().equals(MD5Util.string2MD5(password))) {
            return new SystemResult(105, "密码错误");
        }

        user.setModifiedTime(System.currentTimeMillis() / 1000L);
        userMapper.updateUser(user);

        return new SystemResult(0, "登陆成功", String.valueOf(user.getRegionId()));
    }

    public SystemResult checkUserRegister(User user) {
        if(StringUtils.isEmpty(user.getPhone()) || user.getPhone().length() != 11) {
            return new SystemResult(201, "用户名长度应为11");
        }

        if(StringUtils.isEmpty(user.getPassword()) || user.getPassword().length() < 6 || user.getPassword().length() > 11) {
            return new SystemResult(202, "密码长度应为6~11");
        }

        if (StringUtils.isEmpty(user.getRegionId())) {
            return new SystemResult(203, "地区ID不能为空");
        }

        User checkUser = userMapper.get(user.getPhone());
        if (checkUser != null) {
            return new SystemResult(204, "手机号已注册");
        }

        user.setPassword(MD5Util.string2MD5(user.getPassword()));
        user.setStatus(1);
        user.setCreateTime(System.currentTimeMillis() / 1000L);
        user.setModifiedTime(System.currentTimeMillis() / 1000L);

        userMapper.insert(user);

        return new SystemResult(0, "注册成功");
    }

    public User checkUserByToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.checkToken(token);
                    if (user != null) return user;
                }
            }
        }
        return null;
    }
}
