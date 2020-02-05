package com.wuhan.collecting.interceptor;

import com.wuhan.collecting.mapper.UserMapper;
import com.wuhan.collecting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.checkToken(token);
                    if (user != null) return true;
                }
            }
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.write("{\"status\":0, \"desc\":\"not login!\", \"data\":null}");
//        response.sendRedirect("/login");
        return false;
    }
}
