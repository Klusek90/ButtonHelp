package com.sosapp.sosjerka;

import com.sosapp.sosjerka.Repository.PatronRepository;
import com.sosapp.sosjerka.model.Patron;
import com.sosapp.sosjerka.service.PatronService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatronTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronService patronService;

    @Test
    @DisplayName("Test to save user Patrons")
    public void testOfAddingPatron(){

        Patron patron = new Patron();
        patron.setFirstname("Patronus");
        patron.setSurname("Regionus");
        patron.setMobile("123456123");
        patron.setListPosition(1);
        patron.setUserId(1L);

        Patron patron2 = new Patron();
        patron2.setFirstname("Albert");
        patron2.setSurname("Shultz");
        patron2.setMobile("789456123");
        patron2.setListPosition(2);
        patron2.setUserId(1L);

        List<Patron> patronList = List.of(patron, patron2);
        when(patronRepository.saveAll(patronList)).thenReturn(patronList);

        // When
        List<Patron> savePatrons = patronService.updatePatronList(patronList,1L);

        assertThat(savePatrons).containsExactly(patron, patron2);
    }
}
