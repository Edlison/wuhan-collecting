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
    long checkSampleById(@Param("locId") long locId);

    @Delete("Delete from sample where id = #{patId}")
    void delete(@Param("patId") String patId);
}
