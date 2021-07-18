package com.flaviomarcilio.productapi.service;

import com.flaviomarcilio.productapi.dto.MessageResponseDTO;
import com.flaviomarcilio.productapi.dto.request.PersonDTO;
import com.flaviomarcilio.productapi.entity.Person;
import com.flaviomarcilio.productapi.exception.PersonNotFoundException;
import com.flaviomarcilio.productapi.mapper.PersonMapper;
import com.flaviomarcilio.productapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PersonDTO> listAll() {

        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person = personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
}
