package com.tutorials.tickets.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table("tickets")
public class Ticket {
    
    @Id
    @NotNull
    @Column("id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="ticket_generator", sequenceName = "ticket_seq")
    private Long id;
    
    @Column("title")
    @NotNull
    private String title;
    
    @Column("description")
    private String description;
    
    @Column("status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    
    @Column("original_estimate")
    private Integer originalEstimate;
    
    @Column("logged_time")
    private Integer loggedTime;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
    
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;
    
    @Column("creation_time")
    @NotNull
    private LocalDateTime creationTime;
    
    @NotNull
    @Column("last_update_time")
    private LocalDateTime lastUpdateTime;
}
