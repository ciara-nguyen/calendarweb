package com.calendar.calendarweb.repositories;

import com.calendar.calendarweb.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
