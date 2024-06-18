package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails saveDetails(UserDetails userDetails){

        userDetailsRepository.save(userDetails);
        return userDetails;
    }




}
