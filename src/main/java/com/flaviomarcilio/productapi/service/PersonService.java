package com.flaviomarcilio.productapi.service;

import com.flaviomarcilio.productapi.dto.MessageResponseDTO;
import com.flaviomarcilio.productapi.dto.request.PersonDTO;
import com.flaviomarcilio.productapi.entity.Person;
import com.flaviomarcilio.productapi.mapper.PersonMapper;
import com.flaviomarcilio.productapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
