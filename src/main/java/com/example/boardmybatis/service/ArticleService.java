package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.mapper2.ArticleMapper;
import com.example.boardmybatis.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public void save(Article article){
        articleRepository.save(article);
    }

    public Article findById(int id){
        return articleRepository.findById(id);
    }

    public void edit(Article article){
        articleRepository.edit(article);
    }

    public void delete(int id){
        articleRepository.delete(id);
    }

    public List<Article> listAll(){
        return articleRepository.getAll();
    }

    public List<Article> findByUserId(String userId){
        return articleRepository.getByUserId(userId);
    }
}
