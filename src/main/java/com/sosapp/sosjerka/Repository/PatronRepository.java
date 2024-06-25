package com.sosapp.sosjerka.Repository;

import com.sosapp.sosjerka.model.MedHistory;
import com.sosapp.sosjerka.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatronRepository extends JpaRepository<Patron, Long> {

    List<Patron> findByUserOrderByListPosition(Long userId);

}
