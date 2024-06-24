package com.sosapp.sosjerka.Repository;

import com.sosapp.sosjerka.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository< Contact, Long> {
    Contact findByPhoneNumber(String number);
}
