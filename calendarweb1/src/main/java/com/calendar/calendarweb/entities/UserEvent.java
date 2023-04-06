package com.calendar.calendarweb.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="event")
public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="text", nullable = false)
    private String text;
    @Column(name = "start",nullable = false)
    private LocalDateTime start;
    @Column(name="end", nullable = false)
    private  LocalDateTime end;
    @Column(name="color")
    private String color;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;
}
