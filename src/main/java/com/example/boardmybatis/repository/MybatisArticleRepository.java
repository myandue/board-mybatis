package com.example.boardmybatis.repository;

import com.example.boardmybatis.domain.Article;
import com.example.boardmybatis.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisArticleRepository implements ArticleRepository{

    private final ArticleMapper mapper;

    @Override
    public void save(Article article) {
        mapper.insert(article);
    }

    @Override
    public Article findById(int id) {
        return mapper.getById(id);
    }

    @Override
    public void edit(Article article) {
        mapper.update(article);
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }
}
