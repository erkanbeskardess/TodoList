package com.erkanbeskardes.todolist.service;

import com.erkanbeskardes.todolist.business.TodoDto;
import com.erkanbeskardes.todolist.data.entity.TodoEntity;
import com.erkanbeskardes.todolist.data.mapper.TodoMapper;
import com.erkanbeskardes.todolist.data.repository.ITodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import java.util.List;
import java.util.stream.Collectors;


@Log4j2

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements ITodoService {

    // injection
    private final TodoMapper todoMapper;
    private final ITodoRepository iTodoRepository;

    @Autowired
    public TodoServiceImpl(ITodoRepository iTodoRepository, TodoMapper todoMapper) {
        this.iTodoRepository = iTodoRepository;
        this.todoMapper = todoMapper;
    }

    public TodoEntity dtoToEntity(TodoDto todoDto) {
        return TodoMapper.todoDtoToTodoEntity(todoDto);
    }

    public TodoDto entityToDto(TodoEntity todoEntity) {
        return TodoMapper.todoEntityToTodoDto(todoEntity);
    }


    @Override
    public List<TodoDto> getAllToDo() {
        List<TodoEntity> todoEntityList = iTodoRepository.findAll();


        if (todoEntityList != null) {

            return todoEntityList.stream()
                    .map(TodoMapper::todoEntityToTodoDto)
                    .collect(Collectors.toList());

        } else {
            throw new NotFoundException("null pointer exception message");
        }

    }


    @Override
    public TodoDto createTodo(TodoDto todoDto) {

        TodoEntity todoEntitySave = dtoToEntity(todoDto);
        return entityToDto(iTodoRepository.save(todoEntitySave));

    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {

        if (iTodoRepository.existsById(id)) {

            TodoEntity todoEntityUpdate = dtoToEntity(findById(id));

            todoEntityUpdate.setId(id);
            todoEntityUpdate.setTitle(todoDto.getTitle());
            todoEntityUpdate.setDescription(todoDto.getDescription());
            todoEntityUpdate.setTaskComplete(todoDto.getTaskComplete());


            todoDto = entityToDto(iTodoRepository.save(todoEntityUpdate));
            return todoDto;
        } else {
            throw new NotFoundException("Hasn't found id: " + id);
        }
    }

        @Override
        public void deleteTodo (Long id){
            if (iTodoRepository.existsById(id)) {
                iTodoRepository.deleteById(id);
            } else {
                throw new NotFoundException("Hasn't found id: " + id);
            }

        }

        @Override
        public TodoDto findById (Long id){
            if (iTodoRepository.existsById(id)) {
                return entityToDto(iTodoRepository.getById(id));
            } else {
                throw new NotFoundException("Hasn't found id: " + id);
            }
        }
    }
