package com.calendar.calendarweb.repositories;

import com.calendar.calendarweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
    public User save(User user);
}
