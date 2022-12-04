package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.session.WebSessionManager;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(User user){
        userRepository.save(user);
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public String login(String userId, String password, HttpServletRequest request){
        Optional<User> userTemp= userRepository.findByUserId(userId);
        if(userTemp.isEmpty()){
            return "no";
        }
        User user = userTemp.get();
        if(user.getPassword().equals(password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("loginUser", user);
            System.out.println("user = " + user);
            return "yes";
        }else{
            return "pw";
        }
    }


}
