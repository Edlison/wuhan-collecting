package com.wuhan.collecting.mapper;

import com.wuhan.collecting.model.Sample;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SampleMapper {

    @Insert("Insert into sample (sample_region_id, sample_date, sample_sex, sample_age, sample_confirm_time, sample_source_text, sample_source_url, sample_user_id, sample_create_time, sample_modified_time) " +
            "values (#{sampleRegionId}, #{sampleDate}, #{sampleSex}, #{sampleAge}, #{sampleConfirmTime}, #{sampleSourceText}, #{sampleSourceUrl}, #{sampleUserId}, #{sampleCreateTime}, #{sampleModifiedTime})")
    void insert(Sample sample);

    @Select("Select level from region where id = #{locId}")
    long checkSampleByLocId(@Param("locId") long locId);

    @Update("Update sample set sample_region_id = #{sampleRegionId}, sample_date = #{sampleDate}, sample_sex = #{sampleSex}, sample_age = #{sampleAge}, sample_confirm_time = #{sampleConfirmTime}, sample_source_text = #{sampleSourceText}, sample_source_url = #{sampleSourceUrl}, sample_user_id = #{sampleUserId}, sample_modified_time = #{sampleModifiedTime} " +
            "where id = #{id} and sample_user_id = #{sampleUserId}")
    int updateById(Sample sample);

    @Delete("Delete from sample where id = #{patId}")
    void delete(@Param("patId") long patId);

    @Select("Select * from sample where id = #{patId}")
    Sample checkId(@Param("patId") long patId);
}
