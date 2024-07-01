package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.model.Patron;
import com.sosapp.sosjerka.service.PatronService;
import com.sosapp.sosjerka.service.UserDetailsService;
import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatronControl {


    @Autowired
    private PatronService patronService;

    public PatronControl(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping("/updateUserPatronList/{userId}")
    public ResponseEntity<List<Patron>> updatePatronList(@RequestBody List<Patron> patrons, @PathVariable Long userId) {
        List<Patron> patron = patronService.updatePatronList(patrons,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(patron);
    }

    @GetMapping("/showPatrons/{userId}")
    public List<Patron> updatePatrons(@PathVariable Long userId) {
        ArrayList<Patron> userPatrons= patronService.allUserPatrons(userId);
        return userPatrons;
    }

}
