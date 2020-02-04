package com.wuhan.collecting.mapper;

import com.wuhan.collecting.model.Case;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CaseMapper {

    @Insert("Insert into `case` (case_region_id, case_date, case_sex, case_age, case_confirm_time, case_source_url, case_user_id, case_create_time, case_modified_time) " +
            "values (#{caseRegionId}, #{caseDate}, #{caseSex}, #{caseAge}, #{caseConfirmTime}, #{caseSourceUrl}, #{caseUserId}, #{caseCreateTime}, #{caseModifiedTime})")
    void insert(Case cases);
}
