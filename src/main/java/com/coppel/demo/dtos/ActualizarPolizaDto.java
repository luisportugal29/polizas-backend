package com.coppel.demo.dtos;

import com.coppel.demo.entities.Empleado;
import com.coppel.demo.entities.Inventario;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarPolizaDto {
    
    @Positive
    private Integer empleadoId;

    @Positive
    private Integer cantidad;

    private Empleado empleado;

    private Inventario inventario;

}
