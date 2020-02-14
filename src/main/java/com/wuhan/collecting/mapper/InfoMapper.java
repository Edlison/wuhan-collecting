package com.wuhan.collecting.mapper;

import com.wuhan.collecting.DTO.GetCountDTO;
import com.wuhan.collecting.DTO.PatientDTO;
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

    @Select("Select id from region where pid = #{locId}")
    List<Long> getNextId(@Param("locId") long locId);

    @Select("Select name from region where id = #{id}")
    String getLocName(@Param("id") long id);

    //    @Select("Select id, count_confirm, count_recover, count_dead, count_source_text, count_source_url from count where count_region_id in (#{locId}) and count_date = #{date}")
    @Select({
            "<script>",
            "select",
            "id, count_region_id, count_confirm, count_recover, count_dead, count_source_text, count_source_url",
            "from count",
            "where count_region_id in",
            "<foreach collection='locId' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            " and count_date = #{date}",
            "</script>"
    })
    List<GetCountDTO> getCount(@Param("locId") List<Long> locId, @Param("date") String date);

    //    @Select("Select id, sample_sex, sample_age, sample_confirm_time, sample_source_text, sample_source_url from sample where sample_region_id = #{locId} and sample_confirm_time = #{date}")
    @Select({
            "<script>",
            "select",
            "id, sample_region_id, sample_sex, sample_age, sample_confirm_time, sample_source_text, sample_source_url",
            "from sample",
            "where sample_region_id in",
            "<foreach collection='locId' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            " and sample_confirm_time = #{date}",
            "</script>"
    })
    List<PatientDTO> getPat(@Param("locId") List<Long> locId, String date);

    @Select("Select level from region where id = #{locId}")
    long checkLevelById(@Param("locId") long locId);
}
