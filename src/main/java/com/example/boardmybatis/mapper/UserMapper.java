package com.example.boardmybatis.mapper;

import com.example.boardmybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name) VALUES(#{user.name})")
    int insert(@Param("user") User user);

}
