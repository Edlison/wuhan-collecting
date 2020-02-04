/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:11
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.wuhan.collecting.model.Case;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/case")
public class CaseController {

    @Autowired
    CaseService caseService;

    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    @ResponseBody
    public SystemResult insert(@RequestBody List<Case> cases) {

        SystemResult res = caseService.insert(cases);

        return res;
    }
}
