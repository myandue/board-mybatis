package com.example.boardmybatis.mapper;

import com.example.boardmybatis.domain.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article(title, content, user_id) VALUES(#{article.title}, #{article.content}, #{article.userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("article") Article article);

    @Select("SELECT * FROM article WHERE id=#{id}")
    @Results(id="ArticleMap", value={
            @Result(property = "userId", column = "user_id")
    })
    Article getById(@Param("id") int id);

    @Select("SELECT * FROM article WHERE user_id=#{userId}")
    @ResultMap("ArticleMap")
    List<Article> getByUserId(@Param("userId") String userId);

    @Select("SELECT * FROM article")
    @ResultMap("ArticleMap")
    List<Article> getAll();

    @Update("UPDATE article SET title=#{article.title}, content=#{article.content} WHERE id=#{article.id}")
    int update(@Param("article") Article article);

    @Delete("DELETE FROM article WHERE id=#{id}")
    int delete(@Param("id") int id);
}
