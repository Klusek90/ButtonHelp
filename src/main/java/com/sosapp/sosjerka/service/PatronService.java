package com.sosapp.sosjerka.service;

import com.sosapp.sosjerka.Repository.PatronRepository;
import com.sosapp.sosjerka.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public Patron updatePatronList(List<Patron> patrons, Long userId){
        List<Patron> current = patronRepository.findByUserOrderByListPosition(userId);

        //remove items from database if new list is shorter
        if(patrons.size()< current.size()){
            int difference =current.size() -patrons.size();
            for(int i=difference; i < current.size(); i++){
                patronRepository.delete(current.get(i));
            }
        }

        for (int j =0; j<patrons.size(); j++){
            if(j< current.size()){
                Long id =current.get(j).getId();
                patrons.get(j).setId(id);
            }

        }
        patronRepository.saveAll(patrons);
        return current.get(0);
    }

    public List<Patron> allUserPatrons(Long user){
        return patronRepository.findByUserOrderByListPosition(user);
    }
}
