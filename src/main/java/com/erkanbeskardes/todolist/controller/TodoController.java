package com.erkanbeskardes.todolist.controller;

import com.erkanbeskardes.todolist.business.TodoDto;
import com.erkanbeskardes.todolist.service.ITodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/todo")
public class TodoController  {
    
    private final ITodoService iTodoService;
    
    @PostMapping("/create")
    public ResponseEntity<TodoDto> createApi(@Valid @RequestBody TodoDto todoDto){
        return ResponseEntity.ok(iTodoService.createTodo(todoDto));
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<TodoDto>> listApi() {

        return ResponseEntity.ok(iTodoService.getAllToDo());

    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> findByIdApi(@PathVariable Long id) {

        return ResponseEntity.ok(iTodoService.findById(id));

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApi(@PathVariable Long id) {
        iTodoService.deleteTodo(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDto> updateApi(@RequestBody TodoDto todoDto, @PathVariable Long id) {

        return ResponseEntity.ok(iTodoService.updateTodo(todoDto,id));

    }
    
    

}
