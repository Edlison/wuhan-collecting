package com.wuhan.collecting.appoint;

import com.wuhan.collecting.DTO.GetCountDTO;
import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import com.wuhan.collecting.mapper.InfoMapper;
import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.model.LocationDAO;
import com.wuhan.collecting.model.PatientDAO;
import com.wuhan.collecting.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public GetCountDTO getCount(long locId, String date) {
        Count count = infoMapper.getCount(locId, date);
        if (count == null) return null;

        GetCountDTO getCountDTO = new GetCountDTO();

        getCountDTO.setId(count.getId());
        getCountDTO.setCountConfirm(count.getCountConfirm());
        getCountDTO.setCountRecover(count.getCountRecover());
        getCountDTO.setCountDead(count.getCountDead());
        getCountDTO.setCountSourceText(count.getCountSourceText());
        getCountDTO.setCountSourceUrl(count.getCountSourceUrl());

        StringBuilder locName = new StringBuilder(infoMapper.getLocName(locId));

        for (int i = 1; i < 4; i++) {
            long preId = infoMapper.getPreId(locId);
            if (preId == 0) break;
            locName.insert(0, infoMapper.getLocName(preId) + "-");
            locId = preId;
        }

        getCountDTO.setLocName(locName.toString());

        return getCountDTO;
    }

    public List<PatientDTO> getPat(long locId, String date) {

        List<PatientDAO> patientDAOS = infoMapper.getPat(locId, date);

        //Data Trans PatientDAO to PatientDTO
        List<PatientDTO> pats = new LinkedList<>();

        if (patientDAOS != null) {
            StringBuilder locName = new StringBuilder(infoMapper.getLocName(locId));

            for (int i = 1; i < 4; i++) {
                long preId = infoMapper.getPreId(locId);
                if (preId == 0) break;
                locName.insert(0, infoMapper.getLocName(preId) + "-");
                locId = preId;
            }

            for (PatientDAO patientDAO : patientDAOS) {
                if (patientDAO != null) {
                    PatientDTO pat = new PatientDTO();

                    pat.setId(patientDAO.getId());
                    pat.setSampleSex(patientDAO.getSampleSex());
                    pat.setSampleAge(patientDAO.getSampleAge());
                    pat.setSampleConfirmTime(patientDAO.getSampleConfirmTime());
                    pat.setSampleSourceText(patientDAO.getSampleSourceText());
                    pat.setSampleSourceUrl(patientDAO.getSampleSourceUrl());
                    pat.setLocName(locName.toString());

                    pats.add(pat);
                }
            }
        }

        return pats;
    }
}
