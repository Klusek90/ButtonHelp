package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.model.MedHistory;
import com.sosapp.sosjerka.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}
