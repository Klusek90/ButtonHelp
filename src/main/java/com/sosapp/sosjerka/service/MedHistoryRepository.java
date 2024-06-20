package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.model.Contact;
import com.sosapp.sosjerka.model.MedHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedHistoryRepository extends JpaRepository<MedHistory, Long> {
}
