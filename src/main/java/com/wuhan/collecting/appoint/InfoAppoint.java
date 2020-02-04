package com.wuhan.collecting.appoint;

import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import com.wuhan.collecting.mapper.InfoMapper;
import com.wuhan.collecting.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoAppoint {

    @Autowired
    InfoMapper infoMapper;

    public List<LocationDTO> getPid(long id) {

        List<LocationDTO> locs = infoMapper.getPid(id);

        return locs;
    }

    public List<PatientDTO> getPat(long locId, String date) {

        List<PatientDTO> pats = infoMapper.getPat(locId, TimeUtil.Date2TimeStamp(date));

        return pats;
    }
}
