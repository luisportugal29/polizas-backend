package com.coppel.demo.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class PolizaDto {

    @Pattern(regexp = "^[A-Z]\\d{3}$", message = "Sku invalido")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String sku;

    @Min(1)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer empleadoId;

    private Integer id;

    @Min(1)
    private Integer cantidad;

    private LocalDate fecha;

    private InventarioDto articulo;

    private EmpleadoDto empleado;


}
