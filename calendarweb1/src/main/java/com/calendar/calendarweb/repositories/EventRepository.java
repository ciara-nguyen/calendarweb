package com.calendar.calendarweb.repositories;

import com.calendar.calendarweb.entities.User;
import com.calendar.calendarweb.entities.UserEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<UserEvent, Long> {

    public  List<UserEvent> findAllByUserAndStartBetween(User user,@Param("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start, @Param("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end);
    public UserEvent findOneById(Long id);
    public UserEvent save(UserEvent userEvent);


}
