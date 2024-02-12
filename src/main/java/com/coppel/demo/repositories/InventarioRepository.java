package com.coppel.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coppel.demo.entities.Inventario;

public interface InventarioRepository extends CrudRepository<Inventario, String> {

    Optional<Inventario> findBySku(String sku);
    
}
