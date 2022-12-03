package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
public class MemoryUserRepository implements UserRepository{

    private static Map<Integer, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findById(int id) {
        return userMap.get(id);
    }
}
