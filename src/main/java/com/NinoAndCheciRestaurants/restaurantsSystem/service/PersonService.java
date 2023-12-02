package com.NinoAndCheciRestaurants.restaurantsSystem.service;


import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonResponse;

import java.util.List;

public interface PersonService {

    PersonResponse createPerson(PersonRequest request);
    void deletePerson(Long id);
    PersonResponse updatePerson(Long id, PersonRequest request);
    List<PersonResponse> getAllPersons();
}
