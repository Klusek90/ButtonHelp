package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.model.MedHistory;
import com.sosapp.sosjerka.model.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostcodeRepository extends JpaRepository<Postcode, Long> {
}
