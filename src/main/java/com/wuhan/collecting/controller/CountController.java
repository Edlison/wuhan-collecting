/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:12
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.wuhan.collecting.DTO.CountDTO;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    CountService countService;

    @PostMapping("/insert")
    @ResponseBody
    public SystemResult insert(CountDTO countDTO, HttpServletRequest request) {

        SystemResult res = countService.insert(countDTO, request);

        return res;
    }

    @PostMapping("/update")
    @ResponseBody
    public SystemResult update(CountDTO countDTO, HttpServletRequest request) {

        SystemResult res = countService.update(countDTO, request);

        return res;
    }

    @PostMapping("/delete")
    @ResponseBody
    public SystemResult delete(@RequestParam(name = "countId") long countId) {

        SystemResult res = countService.delete(countId);

        return res;
    }
}
