package com.slowcode.rescatedepatitas.mascotas.repositories;

import java.util.List;
import java.util.Optional;

import com.slowcode.rescatedepatitas.mascotas.entidades.Publicacion;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    Optional<Publicacion> findById(Long id);

    List<Publicacion> findByPersona(Persona persona);
}
