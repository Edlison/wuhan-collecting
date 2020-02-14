package com.wuhan.collecting.service;

import com.wuhan.collecting.DTO.GetCountDTO;
import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import com.wuhan.collecting.appoint.InfoAppoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    InfoAppoint infoAppoint;

    public List<LocationDTO> getNextLoc(long id) {

        List<LocationDTO> locs = infoAppoint.getPid(id);

        return locs;
    }

    public List<GetCountDTO> getCount(long locId, String date) {

        List<GetCountDTO> getCountDTO = infoAppoint.getCount(locId, date);

        return getCountDTO;
    }

    public List<PatientDTO> getPat(long locId, String date) {

        List<PatientDTO> pats = infoAppoint.getPat(locId, date);

        return pats;
    }
}
