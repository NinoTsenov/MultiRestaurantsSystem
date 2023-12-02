package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;

import com.NinoAndCheciRestaurants.restaurantsSystem.converter.PersonConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Person;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.PersonRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    @Override
    public PersonResponse createPerson(PersonRequest request) {
        Person person = personConverter.createPerson(request);
        Person savedPerson = personRepository.save(person);
        return personConverter.toPersonResponse(savedPerson);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonResponse updatePerson(Long id, PersonRequest request) {

        Person foundPerson = personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person not found"));
        foundPerson.setPersonName(request.getPersonName());
        foundPerson.setPersonPhone(request.getPersonPhone());
        return personConverter.toPersonResponse(foundPerson);
    }

    @Override
    public List<PersonResponse> getAllPersons() {
        List<Person> getAllPersons = personRepository.findAll();
        List<PersonResponse> foundAllPersons = new ArrayList<>();
        if(!getAllPersons.isEmpty()){
            for(Person p : getAllPersons) {
                PersonResponse response = personConverter.toPersonResponse(p);
                foundAllPersons.add(response);
            }
        }
        return foundAllPersons;
    }
}
