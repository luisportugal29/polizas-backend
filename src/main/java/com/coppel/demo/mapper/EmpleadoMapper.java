package com.coppel.demo.mapper;

import com.coppel.demo.dtos.EmpleadoDto;
import com.coppel.demo.entities.Empleado;

public class EmpleadoMapper {

    public static  EmpleadoDto mapToEmpleadoDto(Empleado empleado, EmpleadoDto empleadoDto) {
        empleadoDto.setNombre(empleado.getNombre() + " " + empleado.getApellido());
        empleadoDto.setId(empleado.getId());
        return empleadoDto;
    }
    
}
