package com.coppel.demo.repositories;

import com.coppel.demo.entities.Empleado;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
   
    Optional<Empleado> findById(Integer id);

    List<Empleado> findAll();

}
