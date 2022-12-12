package com.example.boardmybatis.mapper2;

import com.example.boardmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserMapper {

    Optional<User> select(Object vo);
}
