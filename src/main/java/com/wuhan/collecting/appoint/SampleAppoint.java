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
        else
            return new SystemResult(402, "地区ID不正确");

        long level = sampleMapper.checkSampleById(sample.getSampleRegionId());

        if (level < 3)
            return new SystemResult(403, "地区要精确到3级以上");

        if (!StringUtils.isEmpty(sampleDTO.getSampleDate()))
            sample.setSampleDate(TimeUtil.Date2TimeStamp(sampleDTO.getSampleDate()));
        else
            return new SystemResult(404, "日期不能为空");

        if (sampleDTO.getSampleSex() == 0 || sampleDTO.getSampleSex() == 1)
            sample.setSampleSex(sampleDTO.getSampleSex());
        else
            return new SystemResult(405, "性别信息错误");

        if (sampleDTO.getSampleAge() >= 0)
            sample.setSampleAge(sampleDTO.getSampleAge());
        else
            return new SystemResult(406, "年龄信息错误");

        if (!StringUtils.isEmpty(sampleDTO.getSampleConfirmTime()))
            sample.setSampleConfirmTime(TimeUtil.Date2TimeStamp(sampleDTO.getSampleConfirmTime()));
        else
            return new SystemResult(407, "确诊日期不能为空");

        if (!StringUtils.isEmpty(sampleDTO.getSampleSourceText()))
            sample.setSampleSourceText(sampleDTO.getSampleSourceText());
        else
            return new SystemResult(408, "源Text不能为空");

        if (!StringUtils.isEmpty(sampleDTO.getSampleSourceUrl()))
            sample.setSampleSourceUrl(sampleDTO.getSampleSourceUrl());
        else
            return new SystemResult(409, "源URL不能为空");

        if (sampleDTO.getSampleUserId() >= 0)
            sample.setSampleUserId(sampleDTO.getSampleUserId());
        else
            return new SystemResult(410, "填写用户信息不能为空");

        sample.setSampleCreateTime(System.currentTimeMillis() / 1000L);
        sample.setSampleModifiedTime(System.currentTimeMillis() / 1000L);
        sampleMapper.insert(sample);

        return new SystemResult(0, "sample插入成功");
    }

    public SystemResult delete(String patId) {
        sampleMapper.delete(patId);
        return new SystemResult(0, "sample删除成功");
    }

    public SystemResult update(SampleDTO sampleDTO) {
        //Data Trans SampleDTO to Sample
        Sample sample = new Sample();

        if (sampleDTO.getId() >= 0)
            sample.setId(sampleDTO.getId());
        else
            return new SystemResult(401, "更新ID不正确");

        if (sampleDTO.getSampleRegionId() >= 0)
            sample.setSampleRegionId(sampleDTO.getSampleRegionId());
        else
            return new SystemResult(402, "地区ID不正确");

        long level = sampleMapper.checkSampleById(sample.getSampleRegionId());

        if (level < 3)
            return new SystemResult(403, "地区要精确到3级以上");

        if (!StringUtils.isEmpty(sampleDTO.getSampleDate()))
            sample.setSampleDate(TimeUtil.Date2TimeStamp(sampleDTO.getSampleDate()));
        else
            return new SystemResult(404, "日期不能为空");

        if (sampleDTO.getSampleSex() == 0 || sampleDTO.getSampleSex() == 1)
            sample.setSampleSex(sampleDTO.getSampleSex());
        else
            return new SystemResult(405, "性别信息错误");

        if (sampleDTO.getSampleAge() >= 0)
            sample.setSampleAge(sampleDTO.getSampleAge());
        else
            return new SystemResult(406, "年龄信息错误");

        if (!StringUtils.isEmpty(sampleDTO.getSampleConfirmTime()))
            sample.setSampleConfirmTime(TimeUtil.Date2TimeStamp(sampleDTO.getSampleConfirmTime()));
        else
            return new SystemResult(407, "确诊日期不能为空");

        if (!StringUtils.isEmpty(sampleDTO.getSampleSourceText()))
            sample.setSampleSourceText(sampleDTO.getSampleSourceText());
        else
            return new SystemResult(408, "源Text不能为空");

        if (!StringUtils.isEmpty(sampleDTO.getSampleSourceUrl()))
            sample.setSampleSourceUrl(sampleDTO.getSampleSourceUrl());
        else
            return new SystemResult(409, "源URL不能为空");

        if (sampleDTO.getSampleUserId() >= 0)
            sample.setSampleUserId(sampleDTO.getSampleUserId());
        else
            return new SystemResult(410, "填写用户信息不能为空");

        sample.setSampleModifiedTime(System.currentTimeMillis() / 1000L);

        sampleMapper.update(sample);

        return new SystemResult(0, "sample更新成功");
    }
}
