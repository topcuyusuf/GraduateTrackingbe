package org.graduatetrackingsystem.graduatetracking.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notification")
@Data
public class  Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "header")
    private String header;
    @Column(name = "body")
    private String body;
    @Column(name = "active")
    private boolean active;
}
