package com.wuhan.collecting.mapper;

import com.wuhan.collecting.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Select("Select * from user where phone = #{phone}")
    User get(@Param("phone") String phone);

    @Select("Select * from user where token = #{token}")
    User checkToken(@Param("token") String token);

    @Insert("Insert into user (phone, password, region_id, status, create_time, modified_time) " +
            "values (#{phone}, #{password}, #{regionId}, #{status}, #{createTime}, #{modifiedTime})")
    void insert(User user);

    @Update("Update user set token = #{token} where phone = #{phone}")
    void setToken(String phone, String token);
}
