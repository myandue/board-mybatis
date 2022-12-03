package com.example.boardmybatis.mapper;

import com.example.boardmybatis.domain.Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article(title, content) VALUES(#{article.title}, #{article.content})")
    @Options(useGeneratedKeys = true, keyProperty = "id") //이거 없어도 될것같기는 한데
    int insert(@Param("article") Article article);

    @Select("SELECT * FROM article WHERE id=#{id}")
    Article getById(@Param("id") int id);

    @Update("UPDATE article SET title=#{article.title}, content=#{article.content} WHERE id=#{article.id}")
    int update(@Param("article") Article article);

    @Delete("DELETE FROM article WHERE id=#{id}")
    int delete(@Param("id") int id);
}
