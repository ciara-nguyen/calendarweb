package com.calendar.calendarweb.controllers;


import com.calendar.calendarweb.dto.EventDto;
import com.calendar.calendarweb.entities.CustomUserDetail;
import com.calendar.calendarweb.entities.User;
import com.calendar.calendarweb.entities.UserEvent;
import com.calendar.calendarweb.repositories.EventRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController

public class ApiController {

    @Autowired
    EventRepository er;

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Welcome!";
    }

    @GetMapping("/api/events")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    Iterable<EventDto> events(@AuthenticationPrincipal CustomUserDetail userDetail, @RequestParam("start") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start, @RequestParam("end") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end) {
        HashSet<EventDto> l= new HashSet<>();
        er.findAllByUserAndStartBetween(userDetail.getUser(),start, end).forEach(a -> l.add(new EventDto(a.getId(),a.getText(),a.getStart(),a.getEnd(),a.getColor())));
        return l;
    }

    @PostMapping("/api/events/create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    EventDto createEvent(@RequestBody EventCreateParams params, @AuthenticationPrincipal CustomUserDetail userDetail) {

        UserEvent e = new UserEvent();
        e.setStart(params.start);
        e.setEnd(params.end);
        e.setText(params.text);
        e.setColor("#1066a8");
        e.setUser(userDetail.getUser());
        er.save(e);

        return new EventDto(e.getId(),e.getText(),e.getStart(),e.getEnd(),e.getColor());
    }

    @PostMapping("/api/events/move")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    EventDto moveEvent(@RequestBody EventMoveParams params) {

        UserEvent e = er.findOneById(params.id);

        e.setStart(params.start);
        e.setEnd(params.end);

        er.save(e);

        return new EventDto(e.getId(),e.getText(),e.getStart(),e.getEnd(),e.getColor());
    }

    @PostMapping("/api/events/setColor")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    EventDto setColor(@RequestBody SetColorParams params) {

        UserEvent e = er.findOneById(params.id);
        e.setColor(params.color);
        er.save(e);

        return new EventDto(e.getId(),e.getText(),e.getStart(),e.getEnd(),e.getColor());
    }

    public static class EventCreateParams {
        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
        public Long resource;
    }

    public static class EventMoveParams {
        public Long id;
        public LocalDateTime start;
        public LocalDateTime end;
        public Long resource;
    }

    public static class SetColorParams {
        public Long id;
        public String color;
    }


}
