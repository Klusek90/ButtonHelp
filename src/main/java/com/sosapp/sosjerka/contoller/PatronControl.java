package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.model.Patron;
import com.sosapp.sosjerka.service.PatronService;
import com.sosapp.sosjerka.service.UserDetailsService;
import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatronControl {


    @Autowired
    private PatronService patronService;

    public PatronControl(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping("/updateUserDetails/{id}")
    public ResponseEntity<Patron> updatePatronList(@RequestBody List<Patron> patrons, @PathVariable Long id) {
        Patron patron = patronService.updatePatronList(patrons,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(patron);
    }

    @GetMapping("/showPatrons/{id}")
    public List<Patron> updatePatrons(@PathVariable Long id) {
        List<Patron> userPatrons= patronService.allUserPatrons(id);
        Patron patron = new Patron();
        userPatrons.add(patron);
        return userPatrons;
    }

}
