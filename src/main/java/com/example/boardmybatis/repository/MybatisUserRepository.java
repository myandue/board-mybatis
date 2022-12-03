package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository{

    private final UserMapper mapper;
    @Override
    public void save(User user) {
        mapper.insert(user);
    }

    @Override
    public User findById(int id) {
        return mapper.getById(id);
    }
}
