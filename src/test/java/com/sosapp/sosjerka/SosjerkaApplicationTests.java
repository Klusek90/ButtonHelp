package com.sosapp.sosjerka;

import com.sosapp.sosjerka.model.UserDetails;
import com.sosapp.sosjerka.service.UserDetailsRepository;
import com.sosapp.sosjerka.service.UserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName("John Doe");
        userDetails.setEmail("john.doe@example.com");

        when(userDetailsRepository.save(userDetails)).thenReturn(userDetails);

        // When
        UserDetails savedUserDetails = userDetailsService.saveDetails(userDetails);

        // Then
        assertThat(savedUserDetails).isNotNull();
        assertThat(savedUserDetails.getFirstName()).isEqualTo(userDetails.getFirstName());
        assertThat(savedUserDetails.getEmail()).isEqualTo(userDetails.getEmail());
    }
}
