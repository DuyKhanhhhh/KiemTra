package com.example.kiemtragiuaky.service.impl;

import com.example.kiemtragiuaky.model.Computer;
import com.example.kiemtragiuaky.repository.IComputerRepository;
import com.example.kiemtragiuaky.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository iComputerRepository;
    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return iComputerRepository.save(computer);
    }

    @Override
    public void delete(Long id) {
        iComputerRepository.deleteById(id);
    }
}
