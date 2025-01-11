package com.erkanbeskardes.todolist.business;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class TodoDto extends BaseDto{

    private String description;

    @Size(min = 5, max = 15,message = "At least 5 and at most 15 characters are required.")
    @NotNull(message = "Title cannot be null")
    private String title;

    private Boolean taskComplete = false;
}
