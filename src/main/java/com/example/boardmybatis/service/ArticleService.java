package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.mapper2.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleMapper articleMapper;

    public void save(Article article){
        articleMapper.insert(article);
    }

    public Article findById(int id){
        return articleMapper.select(id);
    }

    public void edit(Article article){
        articleMapper.update(article);
    }

    public void delete(int id){
        articleMapper.delete(id);
    }

    public List<Article> listAll(){
        return articleMapper.select();
    }

    public List<Article> findByUserId(String userId){
        return articleMapper.select(userId);
    }
}
