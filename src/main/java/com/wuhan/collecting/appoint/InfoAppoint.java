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

import java.util.ArrayList;
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

    public List<GetCountDTO> getCount(long locId, String date) {
        List<Long> allLocId = getAllLocId(locId);
        if (allLocId == null) return null;

        List<GetCountDTO> counts = infoMapper.getCount(allLocId, date);

        if (counts == null) return null;

        for (GetCountDTO count : counts) {
            StringBuilder locName = getLocName(count.getCountRegionId());
            count.setLocName(locName.toString());
        }

        return counts;
    }

    public List<PatientDTO> getPat(long locId, String date) {
        List<Long> allLocId = getAllLocId(locId);
        if (allLocId == null) return null;

        List<PatientDTO> patients = infoMapper.getPat(allLocId, date);

        if (patients == null) return null;

        for (PatientDTO patient : patients) {
            StringBuilder locName = getLocName(patient.getSampleRegionId());
            patient.setLocName(locName.toString());
        }

        return patients;
    }

    private StringBuilder getLocName(long locId) {
        StringBuilder locName = new StringBuilder(infoMapper.getLocName(locId));
        for (int i = 1; i < 4; i++) {
            long preId = infoMapper.getPreId(locId);
            if (preId == 0) break;
            locName.insert(0, infoMapper.getLocName(preId) + "-");
            locId = preId;
        }
        return locName;
    }

    private List<Long> getAllLocId(long locId) {
        long level = infoMapper.checkLevelById(locId);
        if (level < 2) return null;

        List<Long> tempId = infoMapper.getNextId(locId);
        List<Long> allId = new ArrayList<>(tempId);
        for (long i = level + 1; i < 4; i++) {
            int j = 0;
            while (j < tempId.size()) {
                Long top = tempId.get(j);
                List<Long> nextId = infoMapper.getNextId(top);
                allId.addAll(nextId);
                j++;
            }
        }
        return allId;
    }
}
