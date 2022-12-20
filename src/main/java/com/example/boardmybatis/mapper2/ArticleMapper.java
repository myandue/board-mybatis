package com.example.boardmybatis.mapper2;

import com.example.boardmybatis.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    void insert(Article article);
    Article select(int id);
    List<Article> select();
    List<Article> select(String userId);
    void update(Article article);
    void articleHitsUpdate(int id);
    void delete(int id);
}