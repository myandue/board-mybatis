package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/upload")
    public String getUpload(Model model,
                            @SessionAttribute(name="loginUser", required = false) User loginUser){
        if(loginUser==null){
            model.addAttribute("msg", "Only user have access.");
            model.addAttribute("searchUrl","login");
            return "msg";
        }
        model.addAttribute("loginUser",loginUser);
        model.addAttribute("title", "UPLOAD");
        return "/article/upload";
    }

    @PostMapping("/upload")
    public String postUpload(Article article,
                            @SessionAttribute(name="loginUser", required = false) User loginUser)
    {
        if(loginUser==null){
            return "redirect:/login";
        }
        article.setHits(0);
        article.setUserId(loginUser.getUserId());
        articleService.save(article);
        return "redirect:/article/"+article.getId();
    }

    @GetMapping("/{id}")
    public String detail(Model model,
                         @PathVariable("id") int id,
                         @SessionAttribute(name="loginUser", required = false) User loginUser){
        articleService.articleHitsUpdate(id);
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        model.addAttribute("title", article.getTitle());
        if(loginUser!=null) {
            if (article.getUserId().equals(loginUser.getUserId())) {
                model.addAttribute("sameUser", 1);
            }
        }else{
            loginUser = new User();
        }
        model.addAttribute("loginUser", loginUser);
        return "/article/detail";
    }

    @GetMapping("/{id}/edit")
    public String getEditArticle(Model model,
                                 @PathVariable("id") int id,
                                 @SessionAttribute(name="loginUser", required = false) User loginUser){
        if(!articleService.findById(id).getUserId().equals(loginUser.getUserId())){
            return "redirect:/article/" + id;
        }
        model.addAttribute("article",articleService.findById(id));
        model.addAttribute("title","EDIT");
        return "/article/edit";
    }

    @PutMapping("/{id}/edit")
    public String putEditArticle(Article article){
        articleService.edit(article);
        return "redirect:/article/"+article.getId();
    }

    @DeleteMapping("/{id}/delete")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.delete(id);
        return "redirect:/";
    }
}
