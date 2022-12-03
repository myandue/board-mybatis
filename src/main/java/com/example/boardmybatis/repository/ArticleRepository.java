package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.Article;

public interface ArticleRepository {

    void save(Article article);
    Article findById(int id);
}
