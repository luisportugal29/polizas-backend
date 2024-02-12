package com.coppel.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "polizas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Poliza {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer cantidad;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", insertable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "articulo")
    private Inventario articulo;

    @ManyToOne
    @JoinColumn(name = "empleado")
    private Empleado empleado;
    
}
