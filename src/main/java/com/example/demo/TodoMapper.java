package com.example.demo;

import java.util.List;

public interface TodoMapper {

    List<Todo> findAll();

    void insert(Todo todo);
}
