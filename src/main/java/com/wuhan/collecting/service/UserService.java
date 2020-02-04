package com.wuhan.collecting.service;

import com.wuhan.collecting.appoint.UserAppoint;
import com.wuhan.collecting.mapper.UserMapper;
import com.wuhan.collecting.model.User;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserAppoint userAppoint;

    @Autowired
    UserMapper userMapper;

    public SystemResult login(String phone, String password, HttpServletResponse response, HttpServletRequest request) {

        SystemResult res = userAppoint.checkUserLogin(phone, password);

        if (res.getStatus() == 100) {
            String token = UUID.randomUUID().toString();
            CookieUtil.setCookie(response, request, "token", token, 60 * 60 * 24);
            userMapper.setToken(phone, token);
        }

        return res;
    }

    public SystemResult register(User user) {

        SystemResult res = userAppoint.checkUserRegister(user);

        return res;
    }
}
