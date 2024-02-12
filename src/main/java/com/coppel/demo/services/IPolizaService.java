package com.coppel.demo.services;

import java.util.List;

import com.coppel.demo.dtos.ActualizarPolizaDto;
import com.coppel.demo.dtos.PolizaDto;

public interface IPolizaService {
    
    /**
     * @return List
     */
    List<PolizaDto> getPolizas();

    /**
     * @param id - id de la poliza
     * @return
     */
    PolizaDto getPoliza(Integer id);

    /**
     * @param gurdarPolizaDto - detalles de la poliza
     * @return Poliza
     */
    PolizaDto savePoliza(PolizaDto poliza);

    /**
     * @param id
     * @param ActualizaPolizaDto
     * @return Poliza
     */
    PolizaDto updatePoliza(Integer id, ActualizarPolizaDto body);

    /**
     * @param id
     */
    void deletePoliza(Integer id);

    
} 