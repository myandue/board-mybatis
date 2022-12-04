package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper.UserMapper;
import com.example.boardmybatis.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{

    private final UserService userService;

    @GetMapping("/{id}")
    public String userProfile(Model model,
                              @PathVariable("id") int id,
                              @SessionAttribute(name="loginUser", required=false) User loginUser){
        if(loginUser!=null){
            model.addAttribute("loginUser",loginUser);
        }
        Optional<User> userTemp = userService.findById(id);
        if(userTemp.isEmpty()){
            return "redirect:/";
        }
        User user = userTemp.get();
        model.addAttribute("user", user);
        model.addAttribute("title",user.getUserId());
        return "/user/user-profile";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
