package com.example.boardmybatis.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.sql.Date;

@Data
public class Reply {

    private int id;
    private int articleId;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
