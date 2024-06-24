package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.service.UserDetailsService;
import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class HealthControl {


    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/addMedicine")
    public ResponseEntity<UserDetails> addMedicine(@RequestBody UserDetails user) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("updateMedicine/{id}")
    public ResponseEntity<UserDetails> updateMedicine(@RequestBody UserDetails user, @PathVariable Long id) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/medicineList")
    public ResponseEntity<UserDetails> getuserMedicineList(@PathVariable Long id) {
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

    @PostMapping("/addAlergen")
    public ResponseEntity<UserDetails> addAlergen(@RequestBody UserDetails user) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("updateAlergen/{id}")
    public ResponseEntity<UserDetails> updateAlergen(@RequestBody UserDetails user, @PathVariable Long id) {
        UserDetails savedUser = userDetailsService.saveDetails(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/alergenList/{id}")
    public ResponseEntity<UserDetails> getUserAlergenList(@PathVariable Long id) {
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

}
