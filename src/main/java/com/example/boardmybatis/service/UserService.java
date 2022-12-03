package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(User user){
        userRepository.save(user);
    }

    public User findById(int id){
        return userRepository.findById(id);
    }


}
