package com.example.boardmybatis.mapper2;

import com.example.boardmybatis.domain.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {

    void insert(Reply reply);
    List<Reply> select(int articleId);
    void update(Reply reply);
    void delete(int id);
}
