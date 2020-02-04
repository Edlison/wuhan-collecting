package com.wuhan.collecting.appoint;

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

    public SystemResult insert(Count count) {

        if (count == null) {
            return new SystemResult(301, "请填写表单");
        }

        if (!StringUtils.isEmpty(count.getCountDate())) {   //还要约束
            count.setCountDate(TimeUtil.Date2TimeStamp(count.getCountDate()));
        }

        count.setCountCreateTime(System.currentTimeMillis());
        count.setCountModifiedTime(System.currentTimeMillis());

        countMapper.insert(count);

        return new SystemResult(300, "count插入成功");
    }
}
