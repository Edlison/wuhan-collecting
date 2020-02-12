package com.wuhan.collecting.service;

import com.wuhan.collecting.DTO.CountDTO;
import com.wuhan.collecting.appoint.CountAppoint;
import com.wuhan.collecting.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CountService {

    @Autowired
    CountAppoint countAppoint;

    public SystemResult insert(CountDTO countDTO, HttpServletRequest request) {

        SystemResult res = countAppoint.insert(countDTO, request);

        return res;
    }

    public SystemResult update(CountDTO countDTO, HttpServletRequest request) {

        SystemResult res = countAppoint.update(countDTO, request);

        return res;
    }

    public SystemResult delete(long countId, HttpServletRequest request) {
        SystemResult res = countAppoint.delete(countId, request);
        return res;
    }
}
