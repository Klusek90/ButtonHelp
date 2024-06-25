package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.Repository.UserDetailsRepository;
import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Transactional
    public UserDetails saveUserDetails(UserDetails userDetails){
        return userDetailsRepository.save(userDetails);
    }

    public Optional<UserDetails> findUserById(Long id){
        return userDetailsRepository.findById(id);
    }

    public List<UserDetails> findAll(){
        return userDetailsRepository.findAll();
    }




}
