package com.wuhan.collecting.service;

import com.wuhan.collecting.DTO.SampleDTO;
import com.wuhan.collecting.appoint.SampleAppoint;
import com.wuhan.collecting.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    SampleAppoint sampleAppoint;

    public SystemResult insert(List<SampleDTO> sampleDTOS) {

        if (sampleDTOS == null) {
            return new SystemResult(401, "请填写表单");
        }

        for (SampleDTO sampleDTO : sampleDTOS) {
            SystemResult res = sampleAppoint.insert(sampleDTO);
            if (res.getStatus() != 0) return res;
        }

        return new SystemResult(0, "sample插入成功");
    }

    public SystemResult delete(String patId) {

        SystemResult res = sampleAppoint.delete(patId);

        return res;
    }

    public SystemResult update(SampleDTO sampleDTO) {

        SystemResult res = sampleAppoint.update(sampleDTO);

        return res;
    }
}
