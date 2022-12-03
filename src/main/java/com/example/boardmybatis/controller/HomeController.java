package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/join")
    public String getJoin(){
        return "join";
    }

    @PostMapping("/join")
    public String postJoin(User user){
        userService.join(user);
        return "redirect:/";
    }
}
