package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
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
}
