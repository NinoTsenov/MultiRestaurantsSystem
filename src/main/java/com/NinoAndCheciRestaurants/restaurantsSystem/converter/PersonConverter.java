package com.NinoAndCheciRestaurants.restaurantsSystem.converter;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor


public class PersonConverter {

    public Person createPerson(PersonRequest request){

        return Person.builder()
                .personName(request.getPersonName())
                .personPhone(request.getPersonPhone())
                .build();
    }

    public PersonResponse toPersonResponse (Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .personName(person.getPersonName())
                .personPhone(person.getPersonPhone())
                .build();
    }
}
