/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:12
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.wuhan.collecting.utils.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

//    @GetMapping("/logout")
//    public String logout(HttpServletResponse response, HttpServletRequest request) {
//
//        CookieUtil.setCookie(response, request, "token", null, 0);
//
//        return "redirect:/login";
//    }
}
