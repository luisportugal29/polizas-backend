package com.coppel.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coppel.demo.entities.Poliza;

public interface PolizaRepository extends CrudRepository<Poliza, Integer> {
    
    Optional<Poliza> findById(Integer id);

    List<Poliza> findAll();

}
