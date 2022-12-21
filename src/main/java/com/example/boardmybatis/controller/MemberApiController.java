package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

    private final UserService userService;

    @PostMapping("/members/search")
    public String searchMembers(Model model){
        List<User> findMembers = userService.findAll();
        System.out.println("findMembers = " + findMembers);
        model.addAttribute("members", findMembers);

        return "member-list";
    }
}
