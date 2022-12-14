package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryArticleRepository implements ArticleRepository{

    private static Map<Integer, Article> articleMap = new HashMap<>();

    @Override
    public void save(Article article) {
        articleMap.put(article.getId(),article);
    }

    @Override
    public Article findById(int id) {
        return articleMap.get(id);
    }

    @Override
    public void edit(Article article) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Article> getAll() {
        return null;
    }

    @Override
    public List<Article> getByUserId(String userId) {
        return null;
    }
}
