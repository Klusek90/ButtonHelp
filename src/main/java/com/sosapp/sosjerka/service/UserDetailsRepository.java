package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
