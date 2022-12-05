package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);
    Optional<User> findByUserId(String userId);
    Optional<User> findById(int id);
    void edit(User user);
    void delete(int id);
}
