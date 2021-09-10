package com.slowcode.rescatedepatitas.mascotas.repositories;

import com.slowcode.rescatedepatitas.personas.entidades.MedioComunicacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MediosRepository extends JpaRepository<MedioComunicacion, Long>{
    
}
