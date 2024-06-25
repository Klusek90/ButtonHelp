package com.sosapp.sosjerka.Repository;
import com.sosapp.sosjerka.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
