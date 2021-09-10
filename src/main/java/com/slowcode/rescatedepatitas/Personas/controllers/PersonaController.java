package com.slowcode.rescatedepatitas.personas.controllers;

import java.util.Optional;

import com.slowcode.rescatedepatitas.mascotas.entidades.Mascota;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MascotaPersonaRequest;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MascotaRequest;
import com.slowcode.rescatedepatitas.mascotas.repositories.MascotaRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.MediosRepository;
import com.slowcode.rescatedepatitas.personas.entidades.Contacto;
import com.slowcode.rescatedepatitas.personas.entidades.Documento;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;
import com.slowcode.rescatedepatitas.personas.repositories.PersonaRepository;
import com.slowcode.rescatedepatitas.utils.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private MediosRepository mediosRepository;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersonaById(
            @PathVariable Long id
        ){

        try {
            Optional<Persona> persona = this.personaRepository.findById(id);
            if(persona.isPresent()) {
                return ResponseEntity.ok(persona);
            }else{
                return new Tools().error("El id ingresado no existe.");
            }
            
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> registrarMascotayPersona(
            @RequestBody MascotaPersonaRequest mascotaPersonaRequest
        ){
        try {

            Documento documento = new Documento(mascotaPersonaRequest.getNroDocumento(), mascotaPersonaRequest.getTipoDocumento());
            
            Contacto contacto = new Contacto(
                mascotaPersonaRequest.getContactoNombreCompleto(),
                mascotaPersonaRequest.getTelefono(),
                mascotaPersonaRequest.getEmail()
            );

            Persona persona = new Persona(
                mascotaPersonaRequest.getNombreCompleto(),
                mascotaPersonaRequest.getDireccion(),
                mascotaPersonaRequest.getFechaNacimiento(),
                documento,
                contacto
            );
            
            this.personaRepository.save(persona);

            Mascota mascota = new Mascota(
                mascotaPersonaRequest.getNombre(),
                mascotaPersonaRequest.getApodo(), 
                mascotaPersonaRequest.getEdad(),
                mascotaPersonaRequest.getSexo(),
                mascotaPersonaRequest.getDescripcion(),
                mascotaPersonaRequest.getEstado(),
                mascotaPersonaRequest.getClaseAnimal(),
                mascotaPersonaRequest.getFoto(),
                persona);

			this.mascotaRepository.save(mascota);
            
            // MedioComunicacion medio = new MedioComunicacion(
            //     mascotaPersonaRequest.getTipoDeMedio(), 
            //     mascotaPersonaRequest.getMedioPreferido(), 
            //     contacto
            // );

            // this.mediosRepository.save(medio);
            return ResponseEntity.ok(persona);
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }

    @PostMapping("/mascota")
    public ResponseEntity<Object> registrarMascota(
            @RequestBody MascotaRequest mascotaRequest
        ){
        try {
            Optional<Persona> persona = this.personaRepository.findById(mascotaRequest.getPersonaId());

            Mascota mascota = new Mascota(
                mascotaRequest.getNombre(),
                mascotaRequest.getApodo(), 
                mascotaRequest.getEdad(),
                mascotaRequest.getSexo(),
                mascotaRequest.getDescripcion(),
                mascotaRequest.getEstado(),
                mascotaRequest.getClaseAnimal(),
                mascotaRequest.getFoto(),
                persona.get());
            
			this.mascotaRepository.save(mascota);
            return ResponseEntity.ok(mascota);
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }
}
