package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.domain.User;

public interface ArticleRepository {

    void save(Article article);
    Article findById(int id);
    void edit(Article article);
    void delete(int id);
}
