package com.slowcode.rescatedepatitas.personas.repositories;

import java.util.Optional;

import com.slowcode.rescatedepatitas.personas.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);
}
