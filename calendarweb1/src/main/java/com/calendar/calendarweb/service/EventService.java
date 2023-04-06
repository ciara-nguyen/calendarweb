package com.calendar.calendarweb.service;

import com.calendar.calendarweb.dto.EventDto;
import com.calendar.calendarweb.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
   @Autowired
   private EventRepository eventRepository;

}
