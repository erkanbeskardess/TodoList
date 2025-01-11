package com.erkanbeskardes.todolist.data.entity;



import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity(name = "Todo")
@Table(name="todo")
public class TodoEntity extends BaseEntity{

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="task_complete")
    private Boolean taskComplete ;



}
