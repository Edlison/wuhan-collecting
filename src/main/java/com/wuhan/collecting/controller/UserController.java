/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:12
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.wuhan.collecting.DTO.UserDTO;
import com.wuhan.collecting.model.User;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.service.UserService;
import com.wuhan.collecting.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public UserDTO login(String phone, String password, HttpServletResponse response, HttpServletRequest request) {
        SystemResult res = userService.login(phone, password, response, request);

        UserDTO userDTO = new UserDTO();
        userDTO.setStatus(res.getStatus());
        userDTO.setDesc(res.getDesc());

        if (res.getStatus() == 100) {

            userDTO.setRegionId(Long.parseLong(res.getData()));

            return userDTO;
        }

        return userDTO;
    }

    @PostMapping("/register")
    @ResponseBody
    public SystemResult register(User user) {

        SystemResult res = userService.register(user);

        return res;
    }
}
