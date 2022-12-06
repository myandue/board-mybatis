package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper.UserMapper;
import com.example.boardmybatis.service.ArticleService;
import com.example.boardmybatis.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final ArticleService articleService;

    @GetMapping("/")
    public String home(
            Model model,
            @SessionAttribute(name="loginUser", required = false) User loginUser
    ){
        if(loginUser!=null) {
            model.addAttribute("loginUser", loginUser);
            System.out.println("loginUser = " + loginUser);
        }
        model.addAttribute("title", "HOME");
        List<Article> articleList = articleService.listAll();
        model.addAttribute("list",articleList);

        return "home";
    }

    @GetMapping("/join")
    public String getJoin(Model model,
                          @SessionAttribute(name="loginUser", required = false) User loginUser){
        model.addAttribute("title","JOIN");
        return "join";
    }

    @PostMapping("/join")
    public String postJoin(User user,
                           @Param("passwordConfirm") String passwordConfirm,
                           HttpServletRequest request){
        String join = userService.join(user, passwordConfirm);
        if(join.equals("no")){
            return "redirect:/";
        }
        userService.login(user.getUserId(), user.getPassword(), request);
        return "redirect:user/"+user.getId();
    }

    @GetMapping("/login")
    public String getLogin(Model model,
                           @SessionAttribute(name="loginUser", required = false) User loginUser){
        model.addAttribute("title","LOG-IN");
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("userId") String userId,
                            @RequestParam("password") String password,
                            HttpServletRequest request){
        String status = userService.login(userId, password, request);
        if(status.equals("no")){
            //그런 회원 없습니다 메시지
            return "redirect:/login";
        }
        if(status.equals("yes")){
            //성공 메시지
            return "redirect:/";
        }else{
            //패스워드 틀림 메시지
            return "redirect:/login";
        }
    }
}
