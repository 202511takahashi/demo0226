package com.example.demo;

import lombok.Data;

@Data
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
}
