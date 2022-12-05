package com.example.boardmybatis.domain;

import lombok.Data;

@Data
public class Article {

    private int id;
    private String title;
    private String content;
    private String userId;
}
