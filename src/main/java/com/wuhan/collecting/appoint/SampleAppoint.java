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

        if (sampleDTO.getSampleRegionId() >= 0)
            sample.setSampleRegionId(sampleDTO.getSampleRegionId());

        if (!StringUtils.isEmpty(sampleDTO.getSampleDate()))
            sample.setSampleDate(TimeUtil.Date2TimeStamp(sampleDTO.getSampleDate()));

        if (sampleDTO.getSampleSex() >= 0)
            sample.setSampleSex(sampleDTO.getSampleSex());

        if (sampleDTO.getSampleAge() >= 0)
            sample.setSampleAge(sampleDTO.getSampleAge());

        if (!StringUtils.isEmpty(sampleDTO.getSampleConfirmTime()))
            sample.setSampleConfirmTime(TimeUtil.Date2TimeStamp(sampleDTO.getSampleConfirmTime()));

        if (!StringUtils.isEmpty(sampleDTO.getSampleSourceUrl()))
            sample.setSampleSourceUrl(sampleDTO.getSampleSourceUrl());

        if (sampleDTO.getSampleUserId() >= 0)
            sample.setSampleUserId(sampleDTO.getSampleUserId());

        sample.setSampleCreateTime(System.currentTimeMillis() / 1000L);
        sample.setSampleModifiedTime(System.currentTimeMillis() / 1000L);
        sampleMapper.insert(sample);

        return new SystemResult(400, "sample插入成功");
    }

    public SystemResult delete(String patId) {
        sampleMapper.delete(patId);
        return new SystemResult(400, "sample删除成功");
    }
}
