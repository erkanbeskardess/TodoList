package com.erkanbeskardes.todolist.data.entity;

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

public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true)
    protected Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "system_created_date",
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
