package com.sosapp.sosjerka;

import com.sosapp.sosjerka.model.*;
import com.sosapp.sosjerka.Repository.UserDetailsRepository;
import com.sosapp.sosjerka.service.UserDetailsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsTest {


    @Mock
    private UserDetailsRepository userDetailsRepository;


    @InjectMocks
    private UserDetailsService userDetailsService;

    @Test
    @DisplayName("Test of saving user details")
    public void testSaveUserDetails(){

        UserDetails user = new UserDetails();
        user.setFirstname("First Name");
        user.setLastname("Last Name");
        user.setAge(30);
        user.setEmail("email@gmail");
        user.setMobile("07800700");
        user.setType(UserType.USER);
        user.setActive(true);

        when(userDetailsRepository.save(user)).thenReturn(user);

        // When
        UserDetails savedUserDetails = userDetailsService.saveUserDetails(user);

        // Then
        assertThat(savedUserDetails).isNotNull();
        assertThat(savedUserDetails.getFirstname()).isEqualTo("First Name");
        assertThat(savedUserDetails.getEmail()).isEqualTo("email@gmail");
        assertThat(savedUserDetails.getActive()).isTrue();
    }


}
