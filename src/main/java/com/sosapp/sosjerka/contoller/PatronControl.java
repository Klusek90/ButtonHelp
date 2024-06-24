package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.service.UserDetailsService;
import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatronControl {


    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/addPatron")
    public ResponseEntity<UserDetails> addPatron(@RequestBody UserDetails user) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/updatePatrons")
    public ResponseEntity<UserDetails> updatePatrons(@RequestBody UserDetails user) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

}
