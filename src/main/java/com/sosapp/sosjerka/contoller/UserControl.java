package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.model.*;
import com.sosapp.sosjerka.service.UserDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControl {

    @Autowired
    private UserDetailsService userDetailsService;

    public UserControl(UserDetailsService userDetailsService) {
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
        }
    }

    @PostMapping("/saveUserDetails")
    public ResponseEntity<UserDetails> createUser(@Valid @RequestBody UserDetails user) {
        UserDetails savedUser = userDetailsService.saveUserDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    @GetMapping("/all")
    public List<UserDetails> getall(){
       List<UserDetails> all = userDetailsService.findAll();
        return all;
    }


}
