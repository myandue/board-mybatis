package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void save(Article article){
        articleRepository.save(article);
    }

    public Article findById(int id){
        return articleRepository.findById(id);
    }
}
