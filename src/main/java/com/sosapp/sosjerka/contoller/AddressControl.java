package com.sosapp.sosjerka.contoller;

import com.sosapp.sosjerka.model.Address;
import com.sosapp.sosjerka.model.Patron;
import com.sosapp.sosjerka.model.UserDetails;
import com.sosapp.sosjerka.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressControl {

   @Autowired
    private AddressService addressService;

    public AddressControl(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/updateUserAddress/{userId}")
    public ResponseEntity<Address> updatePatronList(@RequestBody Address address, @PathVariable Long userId) {
        Address savedAddress = addressService.saveAndUpdate(address, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @GetMapping("/userAddress/{userId}")
    public ResponseEntity<Address> updatePatrons(@PathVariable Long userId) {
        Optional<Address> userAddress = addressService.findUserAddress(userId);

        if (userAddress.isPresent()) {
            return ResponseEntity.ok(userAddress.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
