package com.erkanbeskardes.todolist.service;

import com.erkanbeskardes.todolist.business.TodoDto;

import java.util.List;

public interface ITodoService {

    List<TodoDto> getAllToDo();

    TodoDto createTodo(TodoDto todoDto);

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    TodoDto findById(Long id);




}
