package com.example.kiemtragiuaky.controller;

import com.example.kiemtragiuaky.model.Person;
import com.example.kiemtragiuaky.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private IPersonService iPersonService;
    @GetMapping
    public ResponseEntity<Iterable<Person>> findAllPerson(){
        List<Person> personList = (List<Person>) iPersonService.findAll();
        if (personList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
                return new ResponseEntity<>(personList,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id){
        Optional<Person> person = iPersonService.findById(id);
        if (!person.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(person.get(),HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Person> saveCustomer(@RequestBody Person person){
        return new ResponseEntity<>(iPersonService.save(person), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person customer){
        Optional<Person> personOptional = iPersonService.findById(id);
        if (!personOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(personOptional.get().getId());
        return new ResponseEntity<>(iPersonService.save(customer), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id){
        Optional<Person> personOptional = iPersonService.findById(id);
        if (!personOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPersonService.delete(id);
        return new ResponseEntity<>(personOptional.get(), HttpStatus.OK);
    }
}
