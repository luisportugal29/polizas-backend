package com.coppel.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.coppel.demo.dtos.ActualizarPolizaDto;
import com.coppel.demo.dtos.PolizaDto;
import com.coppel.demo.entities.Empleado;
import com.coppel.demo.entities.Inventario;
import com.coppel.demo.entities.Poliza;
import com.coppel.demo.mapper.PolizaMapper;
import com.coppel.demo.repositories.EmpleadoRepository;
import com.coppel.demo.repositories.InventarioRepository;
import com.coppel.demo.repositories.PolizaRepository;
import com.coppel.demo.services.IPolizaService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class PolizaServiceImpl implements IPolizaService {

    private PolizaRepository polizaReposiotory;
    private EmpleadoRepository empleadoRepository;
    private InventarioRepository inventarioRepository;

    @Override
    public List<PolizaDto> getPolizas() {

        return this.polizaReposiotory
        .findAll()
        .stream()
        .map(poliza -> PolizaMapper.mapToPolizaDto(poliza, new PolizaDto()))
        .collect(Collectors.toList());
    }

    @Override
    public PolizaDto getPoliza(Integer id) {

        Poliza poliza = this.polizaReposiotory
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poliza No Existe"));

        return PolizaMapper.mapToPolizaDto(poliza, new PolizaDto());

    }

    @Override
    @Transactional
    public PolizaDto savePoliza(PolizaDto polizaDto) {

        Inventario inventario = this.inventarioRepository
            .findBySku(polizaDto.getSku())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Articulo No Existe En Inventario"));

        if ( polizaDto.getCantidad() > inventario.getCantidad())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cantidad excede al inventario");
        
        Empleado empleado = this.empleadoRepository
            .findById(polizaDto.getEmpleadoId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado No Existe"));

        inventario.setCantidad(inventario.getCantidad() - polizaDto.getCantidad());

        Poliza poliza = PolizaMapper.mapToPoliza(polizaDto, new Poliza());
        poliza.setArticulo(inventario);
        poliza.setEmpleado(empleado);
        poliza = this.polizaReposiotory.save(poliza);

        this.inventarioRepository.save(inventario);

        return this.getPoliza(poliza.getId());

    }

    @Override
    @Transactional
    public PolizaDto updatePoliza(Integer id,ActualizarPolizaDto body) {

        Poliza poliza = this.polizaReposiotory
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poliza No Existente"));

        if ( body.getCantidad() > poliza.getCantidad() && body.getCantidad() > poliza.getArticulo().getCantidad() )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cantidad excede al inventario"); 

        this.empleadoRepository
                .findById(body.getEmpleadoId())
                .ifPresentOrElse(body::setEmpleado, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado No Existe");
                });

        int newStock = body.getCantidad() > poliza.getCantidad() 
        ? poliza.getArticulo().getCantidad() - (body.getCantidad() - poliza.getCantidad())
        : poliza.getArticulo().getCantidad() + (poliza.getCantidad() - body.getCantidad());


        poliza.getArticulo().setCantidad(newStock);
        poliza = polizaReposiotory.save( PolizaMapper.mapUpdateToPoliza(body, poliza));
       
        this.inventarioRepository.save(poliza.getArticulo());

        return PolizaMapper.mapToPolizaDto(polizaReposiotory.save(poliza), new PolizaDto());
        
    }

    @Override
    @Transactional
    public void deletePoliza(Integer id) {

        Poliza poliza = this.polizaReposiotory
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Existe La Poliza Proporcionada"));

        Inventario inventario = poliza.getArticulo();
        inventario.setCantidad(inventario.getCantidad() + poliza.getCantidad());
        this.inventarioRepository.save(inventario);
        this.polizaReposiotory.delete(poliza);

    }
    
}
