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

        if (countDTO.getCountRegionId() >= 0)
            count.setCountRegionId(countDTO.getCountRegionId());
        else
            return new SystemResult(302, "地区ID不正确");

        long level = countMapper.checkCountByLocId(count.getCountRegionId());

        if (level < 3)
            return new SystemResult(303, "地区要精确到3级以上");

        if (!StringUtils.isEmpty(countDTO.getCountDate()))
            count.setCountDate(TimeUtil.Date2TimeStamp(countDTO.getCountDate()));
        else
            return new SystemResult(304, "日期不能为空");

        Count tempCount = countMapper.checkCount(count.getCountRegionId(), count.getCountDate());

        if (countDTO.getCountConfirm() >= 0)
            count.setCountConfirm(countDTO.getCountConfirm());
        else
            return new SystemResult(305, "确诊人数有误");

        if (countDTO.getCountRecover() >= 0)
            count.setCountRecover(countDTO.getCountRecover());
        else
            return new SystemResult(306, "康复人数有误");

        if (countDTO.getCountDead() >= 0)
            count.setCountDead(countDTO.getCountDead());
        else
            return new SystemResult(307, "死亡人数有误");

        if (!StringUtils.isEmpty(countDTO.getCountSourceText()))
            count.setCountSourceText(countDTO.getCountSourceText());
        else
            return new SystemResult(308, "源Text不能为空");

        if (!StringUtils.isEmpty(countDTO.getCountSourceUrl()))
            count.setCountSourceUrl(countDTO.getCountSourceUrl());
        else
            return new SystemResult(309, "源URL不能为空");

        if (countDTO.getCountUserId() >= 0)
            count.setCountUserId(countDTO.getCountUserId());
        else
            return new SystemResult(310, "填写用户信息不能为空");

        if (tempCount == null) {

            count.setCountCreateTime(System.currentTimeMillis() / 1000L);
            count.setCountModifiedTime(System.currentTimeMillis() / 1000L);

            countMapper.insert(count);

            return new SystemResult(0, "count插入成功");
        } else {

            count.setCountModifiedTime(System.currentTimeMillis() / 1000L);

            countMapper.update(count);

            return new SystemResult(0, "count更新成功");
        }
    }
}
