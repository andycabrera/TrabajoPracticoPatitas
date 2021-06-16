package com.slowcode.rescatedepatitas.auth;

import java.util.Optional;

import com.slowcode.rescatedepatitas.personas.entidades.Persona;
import com.slowcode.rescatedepatitas.personas.entidades.Usuario;
import com.slowcode.rescatedepatitas.personas.repositories.UsuarioRepository;
import com.slowcode.rescatedepatitas.utils.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private UsuarioRepository usuarioRepository;

    @Autowired
    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/registro")
    public ResponseEntity<Object> registratUsuario(
            @RequestBody String nombreDeUsuario, 
            @RequestBody String contrasenia,
            @RequestBody Boolean esAdmin,
            @RequestBody Persona persona    
        ){
        try {
            Usuario usuario = new Usuario(nombreDeUsuario, contrasenia, esAdmin, persona);
			this.usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }

    @PostMapping("/loggin")
    public ResponseEntity<Object> loggin(
            @RequestBody String nombreDeUsuario, 
            @RequestBody String contrasenia    
        ){
        
        Optional<Usuario> usuario = usuarioRepository.findByNombreDeUsuario(nombreDeUsuario);
        if(usuario.isPresent() && (contrasenia.equals(usuario.get().getContrasenia()))){
            return ResponseEntity.ok(usuario);
        }else{
            return new Tools().error("Ingreso un Usuario/Contraseña incorrecto");
        }       
    }
}
