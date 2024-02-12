package com.coppel.demo.mapper;

import com.coppel.demo.dtos.ActualizarPolizaDto;
import com.coppel.demo.dtos.EmpleadoDto;
import com.coppel.demo.dtos.InventarioDto;
import com.coppel.demo.dtos.PolizaDto;
import com.coppel.demo.entities.Poliza;

import java.time.LocalDate;

public class PolizaMapper {
 
    public static PolizaDto mapToPolizaDto(Poliza poliza, PolizaDto polizaDto) {
        polizaDto.setId(poliza.getId());
        polizaDto.setFecha(poliza.getFecha());
        polizaDto.setCantidad(poliza.getCantidad());
        polizaDto.setEmpleado(EmpleadoMapper.mapToEmpleadoDto(poliza.getEmpleado(), new EmpleadoDto()));
        polizaDto.setArticulo(InventarioMapper.mapToInventarioDto(poliza.getArticulo(), new InventarioDto()));
        return polizaDto;
    }

    public static Poliza mapToPoliza(PolizaDto polizaDto, Poliza poliza) {
        poliza.setFecha(LocalDate.now());
        poliza.setCantidad(polizaDto.getCantidad());
        return poliza;
    }

    public static Poliza mapUpdateToPoliza(ActualizarPolizaDto polizaDto, Poliza poliza) {
        poliza.setEmpleado(polizaDto.getEmpleado());
        poliza.setCantidad(polizaDto.getCantidad());
        poliza.setFecha(LocalDate.now());
        return poliza;
    }
    
}
