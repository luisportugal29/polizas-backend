package com.coppel.demo.controllers;

import com.coppel.demo.services.IPolizaService;
import org.springframework.web.bind.annotation.RestController;

import com.coppel.demo.dtos.ActualizarPolizaDto;
import com.coppel.demo.dtos.MessageResponseDto;
import com.coppel.demo.dtos.PolizaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/polizas")
@AllArgsConstructor
@Validated
public class PolizaController {

    private final IPolizaService polizaService;

    @GetMapping
    public ResponseEntity<List<PolizaDto>> getPolizas() {
        List<PolizaDto> polizasDto = this.polizaService.getPolizas();
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(polizasDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolizaDto> getPoliza(
        @PathVariable 
        @Pattern(regexp = "\\d+", message = "proporciona un id de poliza valido") 
        String id
    ) {
        PolizaDto polizaDto = this.polizaService.getPoliza(Integer.parseInt(id)); 
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(polizaDto);
    }

    @PostMapping
    public ResponseEntity<PolizaDto> savePoliza(@Valid @RequestBody PolizaDto body) {
        PolizaDto polizaDto = this.polizaService.savePoliza(body);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(polizaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolizaDto> updatePoliza(
    @PathVariable 
    @Pattern(regexp = "\\d+", message = "proporciona un id de poliza valido") 
    String id,
    @RequestBody ActualizarPolizaDto body) 
    {
        PolizaDto polizaDto = this.polizaService.updatePoliza(Integer.parseInt(id), body);
        return ResponseEntity
        .status(200)
        .body(polizaDto);
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deletePoliza(
        @PathVariable 
        @Pattern(regexp = "\\d+", message = "proporciona un id de poliza valido") 
        String id
    ) {
        this.polizaService.deletePoliza(Integer.parseInt(id));
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(new MessageResponseDto("Se elimino correctamente la poliza #" + id));
    }

}
