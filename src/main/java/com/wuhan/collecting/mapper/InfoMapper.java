package com.wuhan.collecting.mapper;

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

    @Select("Select id, sample_sex, sample_age, sample_confirm_time, sample_source_url from sample where sample_region_id = #{locId} and sample_date = #{date}")
    List<PatientDAO> getPat(long locId, long date);
}
