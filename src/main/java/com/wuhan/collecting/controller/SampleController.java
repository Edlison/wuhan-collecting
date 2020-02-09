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

    @PostMapping("/insert")
    @ResponseBody
    public SystemResult insert(@RequestBody List<SampleDTO> sampleDTOS) {

        SystemResult res = sampleService.insert(sampleDTOS);

        return res;
    }

    @PostMapping("/delete")
    @ResponseBody
    public SystemResult delete(@RequestParam(name = "patId") String patId) {

        SystemResult res = sampleService.delete(patId);

        return res;
    }

    @PostMapping("/update")
    @ResponseBody
    public SystemResult update(SampleDTO sampleDTO) {

        SystemResult res = sampleService.update(sampleDTO);

        return res;
    }
}
