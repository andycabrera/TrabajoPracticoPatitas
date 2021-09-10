package com.slowcode.rescatedepatitas.personas.repositories;

import java.util.Optional;

import com.slowcode.rescatedepatitas.personas.entidades.Documento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{
    
    Optional<Documento> findById(Long id);
}
