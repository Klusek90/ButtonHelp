package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.Repository.AddressRepository;
import com.sosapp.sosjerka.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address){
        Address saved = addressRepository.save(address);
        return saved;
    }

    public Optional<Address> findUserAddress(Long id){
        Optional<Address> userAddress =  addressRepository.findById(id);
        return userAddress;
    }
}
