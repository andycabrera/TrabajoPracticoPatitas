package com.slowcode.rescatedepatitas.personas.repositories;

import java.util.Optional;

import com.slowcode.rescatedepatitas.personas.entidades.Persona;
import com.slowcode.rescatedepatitas.personas.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findById(Long id);

    Optional<Persona> findByUsuario(Usuario usuario);
}
