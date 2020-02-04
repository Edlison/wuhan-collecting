/*
 * Copyright (c) 2020.
 *
 * Project Name: collecting.
 * Date: 2020/2/4 下午12:12
 *
 * Author: Edlison.
 */

package com.wuhan.collecting.controller;

import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
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

    @PostMapping("/getNextLoc")
    @ResponseBody
    public List<LocationDTO> getNextLoc(@RequestParam(name = "locId") long locId) {

        List<LocationDTO> locs = infoService.getNextLoc(locId);

        return locs;
    }

    @PostMapping("/getPat")
    @ResponseBody
    public List<PatientDTO> getPat(@RequestParam(name = "locId") long locId,
                                   @RequestParam(name = "date") String date) {

        List<PatientDTO> pats = infoService.getPat(locId, date);

        return pats;
    }

}
