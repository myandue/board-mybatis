package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.mapper.UserMapper;
import com.example.boardmybatis.service.ArticleService;
import com.example.boardmybatis.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{

    private final UserService userService;
    private final ArticleService articleService;

    @GetMapping("/{id}")
    public String userProfile(Model model,
                              @PathVariable("id") String userId,
                              @SessionAttribute(name="loginUser", required=false) User loginUser){
        if(loginUser!=null){
            model.addAttribute("loginUser",loginUser);
        }
        Optional<User> userTemp = userService.findByUserId(userId);
        if(userTemp.isEmpty()){
            return "redirect:/";
        }
        User user = userTemp.get();
        model.addAttribute("user", user);
        model.addAttribute("title",user.getUserId());

        List<Article> myArticleList = articleService.findByUserId(userId);
        model.addAttribute("list", myArticleList);

        return "/user/user-profile";
    }

    @GetMapping("/{id}/edit")
    public String getEditUser(Model model,
                              @PathVariable("id") String userId,
                              @SessionAttribute(name="loginUser", required = false) User loginUser){
        if(!loginUser.getUserId().equals(userId)){
            //로그인 유저와 edit profile 대상이 다를 때 돌려보내기
            return "redirect:/";
        }
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("user", loginUser);
        model.addAttribute("title", "EDIT");
        return "/user/edit";
    }

    @PutMapping("/{userId}/edit")
    public String putEditUser(User user){
        System.out.println("user = " + user);
        userService.edit(user);
        return "redirect:/login";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/";
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
