package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository{

    private final UserMapper mapper;
    @Override
    public void save(User user) {
        mapper.insert(user);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return mapper.getByUserId(userId);
    }

    @Override
    public Optional<User> findById(int id) {
        return mapper.getById(id);
    }

    @Override
    public void edit(User user) {
        mapper.update(user);
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }
}
