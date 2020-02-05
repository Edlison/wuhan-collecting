package com.wuhan.collecting.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void setCookie(HttpServletResponse response, HttpServletRequest request, String name, String value) {
        request.getSession().removeAttribute("token");
        Cookie token = new Cookie(name, value);
        token.setPath("/");
        token.setMaxAge(60 * 60 * 24);
        response.addCookie(token);
    }

    public static void setCookie(HttpServletResponse response, HttpServletRequest request, String name, String value, Integer maxAge) {
        request.getSession().removeAttribute("token");
        Cookie token = new Cookie(name, value);
        token.setPath("/");
        token.setMaxAge(maxAge);
        response.addCookie(token);
    }
}
