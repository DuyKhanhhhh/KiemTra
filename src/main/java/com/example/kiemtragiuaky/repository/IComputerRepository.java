package com.example.kiemtragiuaky.repository;

import com.example.kiemtragiuaky.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends CrudRepository<Computer,Long> {
}
