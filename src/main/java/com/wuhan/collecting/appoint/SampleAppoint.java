package com.wuhan.collecting.appoint;

import com.wuhan.collecting.DTO.SampleDTO;
import com.wuhan.collecting.mapper.SampleMapper;
import com.wuhan.collecting.model.Sample;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SampleAppoint {

    @Autowired
    SampleMapper sampleMapper;

    public SystemResult insert(SampleDTO sampleDTO) {

        if (sampleDTO == null) {
            return new SystemResult(401, "请填写表单");
        }

        //Data Trans SampleDTO to Sample
        Sample sample = new Sample();

        sample.setSampleRegionId(sampleDTO.getSampleRegionId());

        if (!StringUtils.isEmpty(sampleDTO.getSampleDate())) {
            sample.setSampleDate(TimeUtil.Date2TimeStamp(sampleDTO.getSampleDate()));
        }

        sample.setSampleSex(sampleDTO.getSampleSex());
        sample.setSampleAge(sampleDTO.getSampleAge());

        if (!StringUtils.isEmpty(sampleDTO.getSampleConfirmTime())) {
            sample.setSampleConfirmTime(TimeUtil.Date2TimeStamp(sampleDTO.getSampleConfirmTime()));
        }

        if (!StringUtils.isEmpty(sampleDTO.getSampleSourceUrl())) {
            sample.setSampleSourceUrl(sampleDTO.getSampleSourceUrl());
        }

        sample.setSampleUserId(sampleDTO.getSampleUserId());

        sample.setSampleCreateTime(System.currentTimeMillis() / 1000L);
        sample.setSampleModifiedTime(System.currentTimeMillis() / 1000L);
        sampleMapper.insert(sample);

        return new SystemResult(400, "case插入成功");
    }
}
