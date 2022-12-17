package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper2.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public String join(User user, String passwordConfirm){
        if(!passwordConfirm.equals(user.getPassword())){
            return "pw";
        }else if(!userMapper.select(user.getUserId()).isEmpty()){
            return "userId";
        }
        userMapper.insert(user);
        return "save";
    }

    public Optional<User> findById(int id){
        return userMapper.select(id);
    }

    //웹에서 찾을 때는 userId로 찾기
    public Optional<User> findByUserId(String userId){
        return userMapper.select(userId);
    }

    public String login(String userId, String password, HttpServletRequest request){
        Optional<User> userTemp= userMapper.select(userId);
        if(userTemp.isEmpty()){
            return "no";
        }
        User user = userTemp.get();
        if(user.getPassword().equals(password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("loginUser", user);
            return "yes";
        }else{
            return "pw";
        }
    }

    public void edit(User user){
        userMapper.update(user);
    }

    public void delete(int id){
        userMapper.delete(id);
    }


}
