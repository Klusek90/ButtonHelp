package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

    @GetMapping("/")
    public UserDetails mainUserInfo(){
        UserDetails user = new UserDetails();
        user.setAge(15);
        user.setFirstName("klusko");
        user.setLocation("kluczbork");
        return user;
    }
}
