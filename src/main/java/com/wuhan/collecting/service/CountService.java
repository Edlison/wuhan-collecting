package com.wuhan.collecting.service;

import com.wuhan.collecting.DTO.CountDTO;
import com.wuhan.collecting.appoint.CountAppoint;
import com.wuhan.collecting.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService {

    @Autowired
    CountAppoint countAppoint;

    public SystemResult insert(CountDTO countDTO) {

        SystemResult res = countAppoint.insert(countDTO);

        return res;
    }

    public SystemResult update(CountDTO countDTO) {

        SystemResult res = countAppoint.update(countDTO);

        return res;
    }

    public SystemResult delete(long countId) {
        SystemResult res = countAppoint.delete(countId);
        return res;
    }
}
