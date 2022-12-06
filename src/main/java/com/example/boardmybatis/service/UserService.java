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

    public String join(User user, String passwordConfirm){
        if(!passwordConfirm.equals(user.getPassword())){
            //pw 틀렸습니다 메시지
            return "no";
        }
        userRepository.save(user);
        return "yse";
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    //웹에서 찾을 때는 userId로 찾기
    public Optional<User> findByUserId(String userId){
        return userRepository.findByUserId(userId);
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
            return "yes";
        }else{
            return "pw";
        }
    }

    public void edit(User user){
        userRepository.edit(user);
    }

    public void delete(int id){
        userRepository.delete(id);
    }


}
