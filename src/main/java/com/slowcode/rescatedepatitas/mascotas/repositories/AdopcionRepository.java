package com.slowcode.rescatedepatitas.mascotas.repositories;

import java.util.List;

import com.slowcode.rescatedepatitas.mascotas.entidades.Adopcion;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {

    List<Adopcion> findByPersona(Persona persona);
}
