package com.wuhan.collecting.appoint;

import com.wuhan.collecting.DTO.CountDTO;
import com.wuhan.collecting.mapper.CountMapper;
import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.model.User;
import com.wuhan.collecting.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class CountAppoint {

    @Autowired
    CountMapper countMapper;

    @Autowired
    UserAppoint userAppoint;

    public SystemResult insert(CountDTO countDTO, HttpServletRequest request) {

        if (countDTO == null) {
            return new SystemResult(301, "请填写表单");
        }

        User user = userAppoint.checkUserByToken(request);
        if (user == null) {
            return new SystemResult(311, "获取token失败");
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
            count.setCountDate(countDTO.getCountDate());
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

        if (user.getId() >= 0)
            count.setCountUserId(user.getId());
        else
            return new SystemResult(310, "用户信息出错");

        if (tempCount == null) {

            count.setCountCreateTime(System.currentTimeMillis() / 1000L);
            count.setCountModifiedTime(System.currentTimeMillis() / 1000L);

            countMapper.insert(count);

            return new SystemResult(0, "count插入成功");
        } else {

            count.setCountModifiedTime(System.currentTimeMillis() / 1000L);

            countMapper.updateByRegionAndDate(count);

            return new SystemResult(0, "count更新成功");
        }
    }

    public SystemResult update(CountDTO countDTO, HttpServletRequest request) {

        User user = userAppoint.checkUserByToken(request);
        if (user == null) {
            return new SystemResult(311, "获取token失败");
        }

        //Data Trans CountDTO to Count
        Count count = new Count();

        if (countDTO.getId() >= 0)
            count.setId(countDTO.getId());
        else
            return new SystemResult(301, "更新ID不正确");

        if (countDTO.getCountRegionId() >= 0)
            count.setCountRegionId(countDTO.getCountRegionId());
        else
            return new SystemResult(302, "地区ID不正确");

        long level = countMapper.checkCountByLocId(count.getCountRegionId());

        if (level < 3)
            return new SystemResult(303, "地区要精确到3级以上");

        if (!StringUtils.isEmpty(countDTO.getCountDate()))
            count.setCountDate(countDTO.getCountDate());
        else
            return new SystemResult(304, "日期不能为空");

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

        if (user.getId() >= 0)
            count.setCountUserId(user.getId());
        else
            return new SystemResult(310, "用户信息出错");

        count.setCountModifiedTime(System.currentTimeMillis() / 1000L);

        int res = countMapper.updateById(count);

        if (res == 0) {
            return new SystemResult(312, "count更新失败");
        }

        return new SystemResult(0, "count更新成功");
    }

    public SystemResult delete(long countId, HttpServletRequest request) {
        User user = userAppoint.checkUserByToken(request);
        if (user == null) {
            return new SystemResult(311, "获取token失败");
        }

        Count count = countMapper.checkId(countId);
        if (count == null) {
            return new SystemResult(321, "没有count记录");
        }

        if (count.getCountUserId() != user.getId()) {
            return new SystemResult(322, "你没有权限操作");
        }

        int countRes = countMapper.delete(countId);
        int sampleRes = countMapper.deleteByCount(count.getCountRegionId(), count.getCountDate());

        if (countRes == 0) {
            return new SystemResult(323, "count记录删除失败");
        }

        if (sampleRes == 0) {
            return new SystemResult(0, "count记录删除成功sample无记录");
        }

        return new SystemResult(0, "count删除成功sample删除成功");
    }
}
