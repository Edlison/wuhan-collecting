package com.wuhan.collecting.mapper;

import com.wuhan.collecting.model.Count;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CountMapper {

    @Insert("Insert into count (count_region_id, count_date, count_confirm, count_recover, count_dead, count_source_url, count_user_id, count_create_time, count_modified_time) " +
            "values (#{countRegionId}, #{countDate}, #{countConfirm}, #{countRecover}, #{countDead}, #{countSourceUrl}, #{countUserId}, #{countCreateTime}, #{countModifiedTime})")
    void insert(Count count);

    @Select("Select level from region where id = #{locId}")
    long checkCountByLocId(@Param("locId") long locId);

    @Select("Select * from count where count_region_id = #{locId} and count_date = #{date}")
    Count checkCount(long locId, long date);

    @Update("Update count set count_confirm = #{countConfirm}, count_recover = #{countRecover}, count_dead = #{countDead}, count_source_url = #{countSourceUrl}, count_user_id = #{countUserId}, count_modified_time = #{countModifiedTime} where count_region_id = #{countRegionId} and count_date = #{countDate}")
    void update(Count count);
}
