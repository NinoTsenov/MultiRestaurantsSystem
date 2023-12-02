package com.NinoAndCheciRestaurants.restaurantsSystem.controller;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.PersonResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/createPerson")
    ResponseEntity<PersonResponse> createPerson (@Valid @RequestBody PersonRequest request){
        PersonResponse createdPerson = personService.createPerson(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @PutMapping("/updatePerson/{id}")
    ResponseEntity<PersonResponse> updatePersonById(@PathVariable Long id, @Valid @RequestBody PersonRequest request){
        PersonResponse updatedPerson = personService.updatePerson(id,request);
        if(updatedPerson!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/getAllPersons")
    ResponseEntity<List<PersonResponse>> fetchAllPersons(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    @DeleteMapping("/deletePersonById")
    ResponseEntity<String> deletePersonById(@PathVariable Long id){
        personService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Person was successfully deleted");
    }

}
