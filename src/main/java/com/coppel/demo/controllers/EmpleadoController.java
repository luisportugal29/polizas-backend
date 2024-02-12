package com.coppel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coppel.demo.entities.Empleado;
import com.coppel.demo.services.impl.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @GetMapping
    public  List<Empleado> getEmpleados() {
        return this.empleadoService.getEmpleados();
    }
    
}
