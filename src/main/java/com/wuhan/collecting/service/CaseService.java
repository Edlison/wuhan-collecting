package com.wuhan.collecting.service;

import com.wuhan.collecting.appoint.CaseAppoint;
import com.wuhan.collecting.model.Case;
import com.wuhan.collecting.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    @Autowired
    CaseAppoint caseAppoint;

    public SystemResult insert(List<Case> cases) {

        if (cases == null) {
            return new SystemResult(401, "请填写表单");
        }

        for (Case element : cases) {
            SystemResult res = caseAppoint.insert(element);
            if (res.getStatus() != 400) return new SystemResult(402, "有表单为空");
        }

        return new SystemResult(400, "case插入成功");
    }
}
