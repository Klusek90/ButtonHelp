package com.sosapp.sosjerka.Repository;

import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findById(Long id);
}
