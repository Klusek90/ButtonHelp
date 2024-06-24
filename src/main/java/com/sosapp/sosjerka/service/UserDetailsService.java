package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.Repository.AddressRepository;
import com.sosapp.sosjerka.Repository.ContactRepository;
import com.sosapp.sosjerka.Repository.PostcodeRepository;
import com.sosapp.sosjerka.Repository.UserDetailsRepository;
import com.sosapp.sosjerka.model.Address;
import com.sosapp.sosjerka.model.Contact;
import com.sosapp.sosjerka.model.Postcode;
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
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PostcodeRepository postcodeRepository;
    @Autowired
    private ContactRepository contactRepository;


    @Transactional
    public UserDetails saveDetails(UserDetails userDetails){

        Address userAddress = userDetails.getAddress();

        if(userAddress.getPostcode() != null){
            Optional<Postcode> findPostcode = postcodeRepository.findByPostcode(userAddress.getPostcode().getPostcode());

            if(findPostcode.isPresent()){
               userAddress.setPostcode(findPostcode.get());
               userDetails.setAddress(userAddress);
            }else {
                postcodeRepository.save(userAddress.getPostcode());
            }
        }

        addressRepository.save(userAddress);

        Contact findContact =  contactRepository.findByPhoneNumber(userDetails.getContact().getPhoneNumber());

        if(findContact != null){
            userDetails.setContact(findContact);
        }else{
            contactRepository.save(userDetails.getContact());
        }
        return  userDetailsRepository.save(userDetails);
    }



    public Optional<UserDetails> findUserById(Long id){

        return userDetailsRepository.findById(id);
    }


    public List<UserDetails> findAll(){
        return userDetailsRepository.findAll();
    }




}
