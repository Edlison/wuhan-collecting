package com.wuhan.collecting.appoint;

import com.wuhan.collecting.DTO.CountDTO;
import com.wuhan.collecting.mapper.CountMapper;
import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CountAppoint {

    @Autowired
    CountMapper countMapper;

    public SystemResult insert(CountDTO countDTO) {

        if (countDTO == null) {
            return new SystemResult(301, "请填写表单");
        }

        //Data Trans CountDTO to Count
        Count count = new Count();

        count.setCountRegionId(countDTO.getCountRegionId());

        if (!StringUtils.isEmpty(countDTO.getCountDate())) {   //还要约束
            count.setCountDate(TimeUtil.Date2TimeStamp(countDTO.getCountDate()));
        }

        count.setCountConfirm(countDTO.getCountConfirm());
        count.setCountRecover(countDTO.getCountRecover());
        count.setCountDead(countDTO.getCountDead());

        if (!StringUtils.isEmpty(countDTO.getCountSourceUrl())) {
            count.setCountSourceUrl(countDTO.getCountSourceUrl());
        }

        count.setCountUserId(countDTO.getCountUserId());

        count.setCountCreateTime(System.currentTimeMillis() / 1000L);
        count.setCountModifiedTime(System.currentTimeMillis() / 1000L);

        countMapper.insert(count);

        return new SystemResult(300, "count插入成功");
    }
}
