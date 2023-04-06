package com.calendar.calendarweb.service;

import com.calendar.calendarweb.dto.UserDto;
import com.calendar.calendarweb.entities.Role;
import com.calendar.calendarweb.entities.User;
import com.calendar.calendarweb.repositories.RoleRepository;
import com.calendar.calendarweb.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }*/

    public void saveUser(UserDto userDto) {
         User user= new User();
         user.setUserName(userDto.getUserName());
         user.setDisplayName(userDto.getDisplayName());
         user.setEmail(userDto.getEmail());
         user.setPassword(passwordEncoder.encode(userDto.getPassword()));
         Role role= roleRepository.findByName("ROLE_USER");
         if (role==null) {
             role = checkRoleExist();
         }
         user.setRoles(Arrays.asList(role));
         userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto=new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setDisplayName(user.getDisplayName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role=new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

}
