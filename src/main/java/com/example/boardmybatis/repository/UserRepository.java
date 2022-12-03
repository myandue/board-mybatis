package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.User;

public interface UserRepository {

    void save(User user);
    User findById(int id);
}
