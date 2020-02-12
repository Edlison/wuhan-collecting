package com.wuhan.collecting.mapper;

import com.wuhan.collecting.model.Count;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CountMapper {

    @Insert("Insert into count (count_region_id, count_date, count_confirm, count_recover, count_dead, count_source_text, count_source_url, count_user_id, count_create_time, count_modified_time) " +
            "values (#{countRegionId}, #{countDate}, #{countConfirm}, #{countRecover}, #{countDead}, #{countSourceText}, #{countSourceUrl}, #{countUserId}, #{countCreateTime}, #{countModifiedTime})")
    void insert(Count count);

    @Select("Select level from region where id = #{locId}")
    long checkCountByLocId(@Param("locId") long locId);

    @Select("Select * from count where count_region_id = #{locId} and count_date = #{date}")
    Count checkCount(long locId, String date);

    @Update("Update count set count_confirm = #{countConfirm}, count_recover = #{countRecover}, count_dead = #{countDead}, count_source_text = #{countSourceText}, count_source_url = #{countSourceUrl}, count_user_id = #{countUserId}, count_modified_time = #{countModifiedTime} " +
            "where count_region_id = #{countRegionId} and count_date = #{countDate}")
    void updateByRegionAndDate(Count count);

    @Update("Update count set count_region_id = #{countRegionId}, count_date = #{countDate}, count_confirm = #{countConfirm}, count_recover = #{countRecover}, count_dead = #{countDead}, count_source_text = #{countSourceText}, count_source_url = #{countSourceUrl}, count_user_id = #{countUserId}, count_modified_time = #{countModifiedTime} " +
            "where id = #{id} and count_user_id = #{countUserId}")
    int updateById(Count count);

    @Delete("Delete from count where id = #{countId}")
    int delete(@Param("countId") long countId);

    @Select("Select * from count where id = #{countId}")
    Count checkId(@Param("countId") long countId);

    @Delete("Delete from sample where sample_region_id = #{locId} and sample_confirm_time = #{date}")
    int deleteByCount(long locId, String date);
}
