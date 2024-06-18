package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.model.*;
import com.sosapp.sosjerka.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserEndpoints {

    @Autowired
    private UserDetailsService userDetailsService;

    public UserEndpoints(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/userDetails/{id}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable Long id) {
        Optional<UserDetails> userDetailsOptional = userDetailsService.findUserById(id);

        // Check if user was found
        if (userDetailsOptional.isPresent()) {
            UserDetails userDetails = userDetailsOptional.get();
            return ResponseEntity.ok(userDetails);
        } else {

            return ResponseEntity.notFound().build();
//            return ResponseEntity.ok(user);
        }
    }

    @PostMapping("/saveUserDetails")
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails user) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
