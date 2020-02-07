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
import com.wuhan.collecting.DTO.GetCountDTO;
import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import com.wuhan.collecting.mapper.InfoMapper;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @Autowired
    InfoMapper infoMapper;

    @PostMapping("/getNextLoc")
    @ResponseBody
    public String getNextLoc(@RequestParam(name = "locId") long locId) {

        List<LocationDTO> locs = infoService.getNextLoc(locId);

//        JSONObject res = new JSONObject();

//        if (locs == null) {
//            SystemResult result = new SystemResult(501, "查找地区ID有误");
//            res.put("SystemResult", result);
//            return res.toJSONString();
//        } else {
//            SystemResult result = new SystemResult(0, "查询成功");
//            res.put("SystemResult", result);
//            res.put("NextLoc", locs);
//            return res.toJSONString();
//        }

        return JSONObject.toJSONString(locs);
    }

    @PostMapping("/getCount")
    @ResponseBody
    public String getCount(@RequestParam(name = "locId") long locId,
                           @RequestParam(name = "date") String date) {
        long level = infoMapper.checkLevelById(locId);
        if (level < 3) {
            SystemResult result = new SystemResult(601, "地区要精确到3级以上");
            return JSONObject.toJSONString(result);
        }

        GetCountDTO getCountDTO = infoService.getCount(locId, date);

        JSONObject res = new JSONObject();

        if (getCountDTO == null) {
            SystemResult result = new SystemResult(602, "无查询结果");
            res.put("status", result.getStatus());
            res.put("desc", result.getDesc());
            return res.toJSONString();
        } else {
            SystemResult result = new SystemResult(0, "查询成功");
            res.put("status", result.getStatus());
            res.put("desc", result.getDesc());
            res.put("Counts", getCountDTO);
            return res.toJSONString();
        }
    }

    @PostMapping("/getPat")
    @ResponseBody
    public String getPat(@RequestParam(name = "locId") long locId,
                         @RequestParam(name = "date") String date) {
        long level = infoMapper.checkLevelById(locId);
        if (level < 3) {
            SystemResult result = new SystemResult(701, "地区要精确到3级以上");
            return JSONObject.toJSONString(result);
        }

        List<PatientDTO> pats = infoService.getPat(locId, date);

        JSONObject res = new JSONObject();

        if (pats == null) {
            SystemResult result = new SystemResult(702, "无查询结果");
            res.put("status", result.getStatus());
            res.put("desc", result.getDesc());
            return res.toJSONString();
        } else {
            SystemResult result = new SystemResult(0, "查询成功");
            res.put("status", result.getStatus());
            res.put("desc", result.getDesc());
            res.put("Patients", pats);
            return res.toJSONString();
        }
    }
}
