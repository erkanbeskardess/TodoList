package com.erkanbeskardes.todolist.data.entity;

import com.erkanbeskardes.todolist.audit.AuditingAwareBaseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

@MappedSuperclass

abstract public class BaseEntity extends AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: Mysql
    @Column(name = "id", insertable = true, updatable = false, unique = true)
    protected Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "system_created_date",
            insertable = true,
            updatable = false,
            nullable = false,
            unique = true,
            length = 20,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date systemCreatedDate;

    @PrePersist
    private void prePersist() {
        if (this.systemCreatedDate == null) {
            this.systemCreatedDate = new Date(System.currentTimeMillis());
        }
    }

} //end BaseDto
