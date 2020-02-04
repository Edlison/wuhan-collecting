package com.wuhan.collecting.appoint;

import com.wuhan.collecting.mapper.CaseMapper;
import com.wuhan.collecting.model.Case;
import com.wuhan.collecting.result.SystemResult;
import com.wuhan.collecting.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CaseAppoint {

    @Autowired
    CaseMapper caseMapper;

    public SystemResult insert(Case element) {

        if (element == null) {
            return new SystemResult(401, "请填写表单");
        }

        if (!StringUtils.isEmpty(element.getCaseDate())) {
            element.setCaseDate(TimeUtil.Date2TimeStamp(element.getCaseDate()));
        }

        if (!StringUtils.isEmpty(element.getCaseConfirmTime())) {
            element.setCaseConfirmTime(TimeUtil.Date2TimeStamp(element.getCaseConfirmTime()));
        }

        element.setCaseCreateTime(System.currentTimeMillis());
        element.setCaseModifiedTime(System.currentTimeMillis());
        caseMapper.insert(element);

        return new SystemResult(400, "case插入成功");
    }
}
