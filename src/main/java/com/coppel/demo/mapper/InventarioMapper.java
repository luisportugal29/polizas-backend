package com.coppel.demo.mapper;

import com.coppel.demo.dtos.InventarioDto;
import com.coppel.demo.entities.Inventario;

public class InventarioMapper {

    public static InventarioDto mapToInventarioDto(Inventario inventario, InventarioDto inventarioDto) {
        inventarioDto.setSku(inventario.getSku());
        inventarioDto.setNombre(inventario.getNombre());
        return inventarioDto;
    }
    
}
