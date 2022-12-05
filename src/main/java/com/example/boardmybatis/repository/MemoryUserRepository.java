package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository{

    private static Map<Integer, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return null;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
