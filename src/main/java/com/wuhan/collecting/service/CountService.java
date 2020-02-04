package com.wuhan.collecting.service;

import com.wuhan.collecting.appoint.CountAppoint;
import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService {

    @Autowired
    CountAppoint countAppoint;

    public SystemResult insert(Count count) {

        SystemResult res = countAppoint.insert(count);

        return res;
    }
}
