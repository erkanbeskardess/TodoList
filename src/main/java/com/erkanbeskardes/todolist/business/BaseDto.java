package com.erkanbeskardes.todolist.business;

import com.erkanbeskardes.todolist.audit.AuditingAwareBaseDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter


abstract public class BaseDto extends AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;


    protected Long id;


    protected Date systemCreatedDate;
} //end BaseDto
