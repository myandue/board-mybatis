package com.example.boardmybatis.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private int id;
    private String name;
    private List<Article> articleList;
}
