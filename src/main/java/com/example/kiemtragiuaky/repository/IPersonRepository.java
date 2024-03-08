package com.example.kiemtragiuaky.repository;

import com.example.kiemtragiuaky.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> {
}
