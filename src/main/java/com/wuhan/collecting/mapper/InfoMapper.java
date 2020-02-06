package com.wuhan.collecting.mapper;

import com.wuhan.collecting.model.Count;
import com.wuhan.collecting.model.LocationDAO;
import com.wuhan.collecting.model.PatientDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface InfoMapper {

    @Select("Select id, level, code, name from region where pid = #{id}")
    List<LocationDAO> getPid(@Param("id") long id);

    @Select("Select pid from region where id = #{locId}")
    long getPreId(@Param("locId") long locId);

    @Select("Select name from region where id = #{id}")
    String getLocName(@Param("id") long id);

    @Select("Select id, count_confirm, count_recover, count_dead, count_source_url, count_user_id from count where count_region_id = #{locId} and count_date = #{date}")
    Count getCount(long locId, long date);

    @Select("Select id, sample_sex, sample_age, sample_confirm_time, sample_source_url from sample where sample_region_id = #{locId} and sample_date = #{date}")
    List<PatientDAO> getPat(long locId, long date);
}
