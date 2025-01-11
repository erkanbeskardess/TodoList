package com.erkanbeskardes.todolist.business;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter


public abstract class BaseDto implements Serializable {


    protected Long id;


    protected Date systemCreatedDate;
} //end BaseDto
