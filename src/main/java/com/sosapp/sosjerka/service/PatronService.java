package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.Repository.PatronRepository;
import com.sosapp.sosjerka.Repository.UserDetailsRepository;
import com.sosapp.sosjerka.model.Patron;
import com.sosapp.sosjerka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public List<Patron> updatePatronList(List<Patron> patrons, Long userId){

        List<Patron> current = new ArrayList<>();
            current = patronRepository.findByUserIdOrderByListPosition(userId);

        if(!(current.isEmpty()) ||  current.size()>0){
            //remove items from database if new list is shorter
            if(patrons.size()< current.size()){
                int difference =current.size() -patrons.size();
                for(int i=difference; i < current.size(); i++){
                    patronRepository.delete(current.get(i));
                }
            }

            for (int j =0; j<patrons.size(); j++) {
                if (j < current.size()) {
                    Long id = current.get(j).getId();
                    patrons.get(j).setId(id);
                }
            }
        }

        patronRepository.saveAll(patrons);
        return patrons;
    }

    public ArrayList<Patron> allUserPatrons(Long userId){
        ArrayList<Patron> userlist=  (ArrayList<Patron>) patronRepository.findByUserIdOrderByListPosition(userId);
        return userlist;
    }
}
