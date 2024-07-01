package com.sosapp.sosjerka.Repository;

import com.sosapp.sosjerka.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByUserid (Long id);

}
