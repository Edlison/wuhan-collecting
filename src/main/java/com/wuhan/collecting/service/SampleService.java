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
            if (res.getStatus() != 400) return new SystemResult(402, "有表单为空");
        }

        return new SystemResult(400, "case插入成功");
    }
}
