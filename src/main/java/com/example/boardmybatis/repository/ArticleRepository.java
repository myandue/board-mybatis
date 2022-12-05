package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.Article;

import java.util.List;

public interface ArticleRepository {

    void save(Article article);
    Article findById(int id);
    void edit(Article article);
    void delete(int id);
    List<Article> getAll();
    List<Article> getByUserId(String userId);
}
