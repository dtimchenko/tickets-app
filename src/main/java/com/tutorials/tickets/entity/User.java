package com.tutorials.tickets.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table("users")
public class User {
    
    @Id
    @NotNull
    @Column("id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq")
    private Long id;
    
    @Column("name")
    @NotNull
    private String name;
    
}
