package com.sosapp.sosjerka;

import com.sosapp.sosjerka.model.*;
import com.sosapp.sosjerka.Repository.UserDetailsRepository;
import com.sosapp.sosjerka.Repository.UserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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

        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstname("Name");
        contact.setSurname("Surname");
        contact.setPhoneNumber("123 123 123");

        UserDetails user = new UserDetails();
        user.setContact(contact);
        user.setAge(30);
        user.setEmail("email");

        Postcode postcode = new Postcode();
        postcode.setId(2L);
        postcode.setCity("City");
        postcode.setPostcode("Postcode");
        postcode.setCounty("County");

        Address address =  new Address();
        address.setAddress1("address1");
        address.setAddress2("address2");
        address.setAddress3("address3");
        address.setPostcode(postcode);

        user.setType(UserType.USER);
        user.setBloodType(BloodType.A_NEGATIVE);


        Patron patron = new Patron();
        patron.setContact(contact);
        patron.setId(3L);

        when(userDetailsRepository.save(user)).thenReturn(user);

        // When
        UserDetails savedUserDetails = userDetailsService.saveDetails(user);

        // Then
        assertThat(savedUserDetails).isNotNull();
        assertThat(savedUserDetails.getContact().getFirstname()).isEqualTo("Name");
        assertThat(savedUserDetails.getEmail()).isEqualTo("email");
        assertThat(savedUserDetails.getBloodType()).isEqualTo(BloodType.A_NEGATIVE);
    }
}
