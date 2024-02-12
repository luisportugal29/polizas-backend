package com.coppel.demo.dtos;

import com.coppel.demo.entities.Empleado;
import com.coppel.demo.entities.Inventario;
import com.coppel.demo.entities.Poliza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolizaResponseDto {

    private Poliza poliza;
    private Empleado empleado;
    private Inventario inventario;


   
    
}
