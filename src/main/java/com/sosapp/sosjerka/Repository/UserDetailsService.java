package com.sosapp.sosjerka.Repository;

import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails saveDetails(UserDetails userDetails){

        userDetailsRepository.save(userDetails);
        return userDetails;
    }

    public Optional<UserDetails> findUserById(Long id){
        return userDetailsRepository.findById(id);
    }



}
