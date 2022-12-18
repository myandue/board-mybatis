package com.example.boardmybatis.service;

import com.example.boardmybatis.domain.Reply;
import com.example.boardmybatis.mapper2.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    public void save(Reply reply){
        replyMapper.insert(reply);
    }

    public List<Reply> listAll(int articleId){
        return replyMapper.select(articleId);
    }

    public void edit(Reply reply){
        replyMapper.update(reply);
    }

    public void delete(int id){
        replyMapper.delete(id);
    }
}
