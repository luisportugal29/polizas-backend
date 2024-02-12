package com.coppel.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coppel.demo.entities.Empleado;
import com.coppel.demo.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl {

    @Autowired
    private EmpleadoRepository repository;

    public List<Empleado> getEmpleados() {
        return this.repository.findAll();
    }
    
}
