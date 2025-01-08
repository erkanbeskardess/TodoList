package com.erkanbeskardes.todolist.audit;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

abstract public class AuditingAwareBaseDto implements Serializable {


    public static final Long serialVersionUID = 1L;

    // AUDITING
    protected String createdBy;

    protected String createdDate;

    protected String lastModifiedBy;

    protected String lastModifiedDate;
}
