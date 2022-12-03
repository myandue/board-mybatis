package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/upload")
    public String getUpload(){
        return "/article/upload";
    }

    @PostMapping("/upload")
    public String postUpload(Article article){
        articleService.save(article);
        return "redirect:/article/"+article.getId();
    }

    @GetMapping("/{id}")
    public String detail(Model model,
                         @PathVariable("id") int id){
        model.addAttribute("article", articleService.findById(id));
        return "/article/detail";
    }

}
