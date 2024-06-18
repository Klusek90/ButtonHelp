package com.sosapp.sosjerka;

import com.sosapp.sosjerka.model.*;
import com.sosapp.sosjerka.service.UserDetailsRepository;
import com.sosapp.sosjerka.service.UserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SosjerkaApplicationTests {


    @Mock
    private UserDetailsRepository userDetailsRepository;

    @InjectMocks
    private UserDetailsService userDetailsService;

    @Test
    public void testSaveUserDetails(){

        UserDetails user = new UserDetails();
        user.setFirstName("imie");
        user.setLastName("nazwisko");
        user.setAge(30);
        user.setLocation("wspolrzedne?");
        user.setEmail("email");

        Address address =  new Address();
        address.setAddress1("address1");
        address.setAddress2("address2");
        address.setAddress3("address3");
        address.setCity("miasto");
        address.setPostcode("kodPocztowy");

        user.setType(UserType.valueOf("USER"));
        user.setBloodType("Rh+");


        Patron patron = new Patron();
        patron.setName("PatronName");
        patron.setPhoneNumber("0700880700");

        Patron patron2 =  new Patron();
        patron2.setName("OtherPatron");
        patron2.setPhoneNumber("18731234568");

        List<Patron> patronlist = new ArrayList<>();
        patronlist.add(patron);
        patronlist.add(patron2);
        user.setPatronList(patronlist);

        List<String> medicine = List.of("Medicine1", "Medicine2", "Medicine3");
        MedicalHistory history = new MedicalHistory();
        history.setIllness("Illnes 1");
        history.setCurrent(true);
        history.setMedicines(medicine);

        MedicalHistory history2 = new MedicalHistory();
        history2.setIllness("Illnes 2");
        history2.setCurrent(false);
        history2.setMedicines(medicine);

        List<MedicalHistory> medicalHistories= new ArrayList<>();

        medicalHistories.add(history);
        medicalHistories.add(history2);
        user.setHistory(medicalHistories);

        when(userDetailsRepository.save(user)).thenReturn(user);

        // When
        UserDetails savedUserDetails = userDetailsService.saveDetails(user);

        // Then
        assertThat(savedUserDetails).isNotNull();
        assertThat(savedUserDetails.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(savedUserDetails.getEmail()).isEqualTo(user.getEmail());
        assertThat(savedUserDetails.getHistory().get(0).getMedicines().get(1)).isEqualTo("Medicine2");
    }
}
