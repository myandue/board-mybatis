package com.example.boardmybatis.mapper2;

import com.example.boardmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    void insert(User user);
    Optional<User> select(String userId);
    Optional<User> select(int id);
    void update(User user);
    void delete(int id);
}
