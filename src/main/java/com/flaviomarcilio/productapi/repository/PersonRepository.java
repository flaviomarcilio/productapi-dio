package com.flaviomarcilio.productapi.repository;

import com.flaviomarcilio.productapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
