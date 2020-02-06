/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:12
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.alibaba.fastjson.JSONObject;
import com.wuhan.collecting.model.User;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(String phone, String password, HttpServletResponse response, HttpServletRequest request) {
        SystemResult res = userService.login(phone, password, response, request);

        JSONObject json = new JSONObject();
        json.put("status", res.getStatus());
        json.put("desc", res.getDesc());

        if (res.getStatus() == 0) {

            json.put("regionId", res.getData());
            json.put("phone", phone);

            return json.toJSONString();
        }

        return json.toJSONString();
    }

    @PostMapping("/register")
    @ResponseBody
    public SystemResult register(User user) {

        SystemResult res = userService.register(user);

        return res;
    }
}
