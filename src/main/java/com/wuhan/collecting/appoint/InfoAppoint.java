package com.wuhan.collecting.appoint;

import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import com.wuhan.collecting.mapper.InfoMapper;
import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.model.LocationDAO;
import com.wuhan.collecting.model.PatientDAO;
import com.wuhan.collecting.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Component
public class InfoAppoint {

    @Autowired
    InfoMapper infoMapper;

    public List<LocationDTO> getPid(long id) {

        List<LocationDAO> locationDAOS = infoMapper.getPid(id);

        //Data Trans LocationDAO to LocationDTO
        List<LocationDTO> locs = new LinkedList<>();

        if (locationDAOS != null) {
            for (LocationDAO locationDAO : locationDAOS) {
                if (locationDAO != null) {
                    LocationDTO loc = new LocationDTO();
                    loc.setId(locationDAO.getId());
                    loc.setLevel(locationDAO.getLevel());
                    loc.setCode(locationDAO.getCode());
                    loc.setName(locationDAO.getName());
                    locs.add(loc);
                }
            }
        }

        return locs;
    }

    public Count getCount(long locId, String date) {

        Count count = infoMapper.getCount(locId, TimeUtil.Date2TimeStamp(date));

        return count;
    }

    public List<PatientDTO> getPat(long locId, String date) {

        List<PatientDAO> patientDAOS = infoMapper.getPat(locId, TimeUtil.Date2TimeStamp(date));

        //Data Trans PatientDAO to PatientDTO
        List<PatientDTO> pats = new LinkedList<>();

        if (patientDAOS != null) {
            for (PatientDAO patientDAO : patientDAOS) {
                if (patientDAO != null) {
                    PatientDTO pat = new PatientDTO();
                    pat.setId(patientDAO.getId());
                    pat.setSampleSex(patientDAO.getSampleSex());
                    pat.setSampleAge(patientDAO.getSampleAge());
                    pat.setSampleConfirmTime(TimeUtil.TimeStamp2Date(patientDAO.getSampleConfirmTime()));
                    if (!StringUtils.isEmpty(patientDAO.getSampleSourceUrl())) {
                        pat.setSampleSourceUrl(patientDAO.getSampleSourceUrl());
                    }
                    pats.add(pat);
                }
            }
        }

        return pats;
    }
}
