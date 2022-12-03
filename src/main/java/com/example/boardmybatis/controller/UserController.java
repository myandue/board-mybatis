package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper.UserMapper;
import com.example.boardmybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{

    private final UserService userService;

    @GetMapping("/{id}")
    public String userProfile(Model model,
                              @PathVariable("id") int id){

        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "/user/user-profile";
    }
}
