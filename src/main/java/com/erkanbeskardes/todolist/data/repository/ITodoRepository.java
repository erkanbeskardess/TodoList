package com.erkanbeskardes.todolist.data.repository;


import com.erkanbeskardes.todolist.data.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<TodoEntity,Long> {


}
