package com.calendar.calendarweb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String displayName;
    @NotEmpty(message = "Email must not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password must not be empty")
    private String password;

}
