package com.slowcode.rescatedepatitas.mascotas.repositories;

import java.util.Optional;

import com.slowcode.rescatedepatitas.mascotas.entidades.Mascota;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    
    Optional<Mascota> findById(Long id);
}
