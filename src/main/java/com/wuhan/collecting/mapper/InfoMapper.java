package com.wuhan.collecting.mapper;

import com.wuhan.collecting.DTO.LocationDTO;
import com.wuhan.collecting.DTO.PatientDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface InfoMapper {

    @Select("Select id, level, code, name from region where pid = #{id}")
    List<LocationDTO> getPid(@Param("id") long id);

    @Select("Select id, case_sex, case_age, case_confirm_time, case_source_url from `case` where case_region_id = #{locId} and case_date = #{date}")
    List<PatientDTO> getPat(long locId, String date);
}
