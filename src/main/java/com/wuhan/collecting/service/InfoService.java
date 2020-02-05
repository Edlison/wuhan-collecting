package com.wuhan.collecting.service;

import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import com.wuhan.collecting.appoint.InfoAppoint;
import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.model.LocationDAO;
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

    public Count getCount(long locId, String date) {

        Count count = infoAppoint.getCount(locId, date);

        return count;
    }

    public List<PatientDTO> getPat(long locId, String date) {

        List<PatientDTO> pats = infoAppoint.getPat(locId, date);

        return pats;
    }
}
