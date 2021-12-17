package com.slowcode.rescatedepatitas.mascotas.repositories;

import java.util.List;

import com.slowcode.rescatedepatitas.mascotas.entidades.IntencionAdopcion;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IntencionAdopcionRepository extends JpaRepository<IntencionAdopcion, Long> {

    List<IntencionAdopcion> findByPersona(Persona persona);
}
