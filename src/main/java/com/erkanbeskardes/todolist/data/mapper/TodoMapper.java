package com.erkanbeskardes.todolist.data.mapper;

import com.erkanbeskardes.todolist.business.TodoDto;
import com.erkanbeskardes.todolist.data.entity.TodoEntity;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TodoMapper {

    public static TodoDto todoEntityToTodoDto(TodoEntity todoEntity){
        TodoDto todoDto = new TodoDto();

        //base dto
        todoDto.setId(todoEntity.getId());
        todoDto.setSystemCreatedDate(todoEntity.getSystemCreatedDate());


        //TodoDto
        todoDto.setTitle(todoEntity.getTitle());
        todoDto.setDescription(todoEntity.getDescription());
        todoDto.setTaskComplete(todoEntity.getTaskComplete());



        return todoDto;
    }

    public static TodoEntity todoDtoToTodoEntity(TodoDto todoDto){
        TodoEntity todoEntity = new TodoEntity();

        //base dto
        todoEntity.setId(todoDto.getId());
        todoEntity.setSystemCreatedDate(todoDto.getSystemCreatedDate());


        //TodoEntity
        todoEntity.setTitle(todoDto.getTitle());
        todoEntity.setDescription(todoDto.getDescription());
        todoEntity.setTaskComplete(todoDto.getTaskComplete());

        return todoEntity;
    }
}
