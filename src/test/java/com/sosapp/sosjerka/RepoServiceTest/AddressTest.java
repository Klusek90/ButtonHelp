package com.sosapp.sosjerka.RepoServiceTest;

import com.sosapp.sosjerka.Repository.AddressRepository;
import com.sosapp.sosjerka.Repository.PatronRepository;
import com.sosapp.sosjerka.model.Address;
import com.sosapp.sosjerka.model.UserDetails;
import com.sosapp.sosjerka.model.UserType;
import com.sosapp.sosjerka.service.AddressService;
import com.sosapp.sosjerka.service.PatronService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class AddressTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    public void AddressServiceTest(){
        Address address = new Address();
        address.setAddress1("Street");
        address.setAddress2("House Number");
        address.setAddress3("Other");
        address.setCounty("Opolskie");
        address.setCity("Kluczbork");
        address.setPostcode("46-200");
        when(addressRepository.save(address)).thenReturn(address);

        // When
        Address savedAddress = addressService.saveAndUpdate(address,1L);

        // Then
        assertThat(savedAddress).isNotNull();
        assertThat(savedAddress.getAddress1()).isEqualTo("Street");
        assertThat(savedAddress.getAddress2()).isEqualTo("House Number");
        assertThat(savedAddress.getCity()).isEqualTo("Kluczbork");
        assertThat(savedAddress.getCounty()).isEqualTo("Opolskie");
        assertThat(savedAddress.getPostcode()).isEqualTo("46-200");
        verify(addressRepository, times(1)).save(address);
    }
}
