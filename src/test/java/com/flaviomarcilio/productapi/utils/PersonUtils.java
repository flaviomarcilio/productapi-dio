package com.flaviomarcilio.productapi.utils;

import com.flaviomarcilio.productapi.dto.request.PersonDTO;
import com.flaviomarcilio.productapi.dto.request.PhoneDTO;
import com.flaviomarcilio.productapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Flavio";
    private static final String LAST_NAME = "Marcilio";
    private static final String CPF_NUMBER = "123.456.789-12";
    private static final Long PERSON_ID = 1L;
    public static final LocalDate BIRTHDATE = LocalDate.of(2015,06,03);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthdate("03-06-2015")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthdate(BIRTHDATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}
