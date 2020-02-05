/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:11
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.wuhan.collecting.DTO.SampleDTO;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sample")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    @ResponseBody
    public SystemResult insert(@RequestBody List<SampleDTO> sampleDTOS) {

        SystemResult res = sampleService.insert(sampleDTOS);

        return res;
    }
}
