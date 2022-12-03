package com.example.boardmybatis.mapper;

import com.example.boardmybatis.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name) VALUES(#{user.name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("user") User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User getById(@Param("id") int id);
}
