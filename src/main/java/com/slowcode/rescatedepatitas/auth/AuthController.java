package com.slowcode.rescatedepatitas.auth;

import java.util.Optional;

import com.slowcode.rescatedepatitas.auth.entidades.UsuarioRequest;
import com.slowcode.rescatedepatitas.auth.entidades.UsuarioRequestLogin;
import com.slowcode.rescatedepatitas.personas.entidades.Usuario;
import com.slowcode.rescatedepatitas.personas.repositories.UsuarioRepository;
import com.slowcode.rescatedepatitas.utils.Tools;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }
    
    private UsuarioRepository usuarioRepository;
    

    @Autowired
    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/registro")
    public ResponseEntity<Object> registratUsuario(
            @RequestBody UsuarioRequest usuarioRequest
        ){
        try {
            Usuario usuario = new Usuario(usuarioRequest.getNombreDeUsuario(), usuarioRequest.getContrasenia(), usuarioRequest.getEsAdmin());
			this.usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }

    @PostMapping("/loggin")
    public ResponseEntity<Object> loggin(
            @RequestBody UsuarioRequestLogin usuarioRequest
        ){
        
        Optional<Usuario> usuario = usuarioRepository.findByNombreDeUsuario(usuarioRequest.getNombreDeUsuario());
        if(usuario.isPresent() && (usuarioRequest.getContrasenia().equals(usuario.get().getContrasenia()))){
            return ResponseEntity.ok(usuario);
        }else{
            return new Tools().error("Ingreso un Usuario/Contraseña incorrecto");
        }       
    }

}
