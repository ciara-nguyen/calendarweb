package com.calendar.calendarweb.dto;

import com.calendar.calendarweb.entities.UserEvent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String text;
    @NotEmpty
    private LocalDateTime start;
    @NotEmpty
    private LocalDateTime end;
    @NotEmpty
    private String color;

}
