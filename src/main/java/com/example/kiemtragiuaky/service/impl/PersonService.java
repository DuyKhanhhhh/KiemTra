package com.example.kiemtragiuaky.service.impl;

import com.example.kiemtragiuaky.model.Person;
import com.example.kiemtragiuaky.repository.IPersonRepository;
import com.example.kiemtragiuaky.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public Iterable<Person> findAll() {
        return iPersonRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return iPersonRepository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return iPersonRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        iPersonRepository.deleteById(id);
    }
}
