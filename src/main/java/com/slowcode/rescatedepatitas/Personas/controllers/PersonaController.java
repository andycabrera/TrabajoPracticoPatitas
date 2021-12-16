package com.slowcode.rescatedepatitas.personas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.slowcode.rescatedepatitas.mascotas.entidades.Caracteristica;
import com.slowcode.rescatedepatitas.mascotas.entidades.Mascota;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.CaracteristicaDto;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MascotaPersonaRequest;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MascotaRequest;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MedioDeComunicacion;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.PersonaRequest;
import com.slowcode.rescatedepatitas.mascotas.repositories.CaracteristicaRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.MascotaRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.MediosRepository;
import com.slowcode.rescatedepatitas.personas.entidades.Contacto;
import com.slowcode.rescatedepatitas.personas.entidades.Documento;
import com.slowcode.rescatedepatitas.personas.entidades.MedioComunicacion;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;
import com.slowcode.rescatedepatitas.personas.entidades.Usuario;
import com.slowcode.rescatedepatitas.personas.repositories.PersonaRepository;
import com.slowcode.rescatedepatitas.personas.repositories.UsuarioRepository;
import com.slowcode.rescatedepatitas.utils.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private MediosRepository mediosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersonaById(
            @PathVariable Long id) {

        try {
            Optional<Persona> persona = this.personaRepository.findById(id);
            if (persona.isPresent()) {
                return ResponseEntity.ok(persona);
            } else {
                return new Tools().error("El id ingresado no existe.");
            }

        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> registrarPersona(
            @RequestBody PersonaRequest personaRequest) {

        try {

            Optional<Usuario> usuario = this.usuarioRepository.findById(personaRequest.getUsuarioId());

            if (usuario.isPresent()) {
                Documento documento = new Documento(personaRequest.getNroDocumento(),
                        personaRequest.getTipoDocumento());

                Contacto contacto = new Contacto(
                        personaRequest.getContactoNombreCompleto(),
                        personaRequest.getTelefono(),
                        personaRequest.getEmail());

                Persona persona = new Persona(
                        personaRequest.getNombreCompleto(),
                        personaRequest.getDireccion(),
                        personaRequest.getFechaNacimiento(),
                        documento,
                        contacto);

                persona.setUsuario(usuario.get());

                this.personaRepository.save(persona);

                for (MedioDeComunicacion medio : personaRequest.getMedios()) {
                    MedioComunicacion newMedio = new MedioComunicacion(
                            medio.getTipoDeMedio(),
                            medio.getMedioPreferido(),
                            contacto);

                    this.mediosRepository.save(newMedio);
                }

                return ResponseEntity.ok(persona);
            } else {
                return new Tools().error("UsuarioId no valido.");
            }

        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }

    }

    @PostMapping("/personamascota")
    public ResponseEntity<Object> registrarMascotayPersona(
            @RequestBody MascotaPersonaRequest mascotaPersonaRequest) {
        try {

            Documento documento = new Documento(mascotaPersonaRequest.getNroDocumento(),
                    mascotaPersonaRequest.getTipoDocumento());

            Contacto contacto = new Contacto(
                    mascotaPersonaRequest.getContactoNombreCompleto(),
                    mascotaPersonaRequest.getTelefono(),
                    mascotaPersonaRequest.getEmail());

            Persona persona = new Persona(
                    mascotaPersonaRequest.getNombreCompleto(),
                    mascotaPersonaRequest.getDireccion(),
                    mascotaPersonaRequest.getFechaNacimiento(),
                    documento,
                    contacto);

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
                    persona, null);

            this.mascotaRepository.save(mascota);

            for (MedioDeComunicacion medio : mascotaPersonaRequest.getMedios()) {
                MedioComunicacion newMedio = new MedioComunicacion(
                        medio.getTipoDeMedio(),
                        medio.getMedioPreferido(),
                        contacto);

                this.mediosRepository.save(newMedio);
            }

            return ResponseEntity.ok(persona);
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }

    @PostMapping("/mascota")
    public ResponseEntity<Object> registrarMascota(
            @RequestBody MascotaRequest mascotaRequest) {
        try {
            List<Caracteristica> listaCaracteristicas = new ArrayList<>();
            Optional<Persona> persona = this.personaRepository.findById(mascotaRequest.getPersonaId());

            for (CaracteristicaDto caracteristicaDto : mascotaRequest.getCaracteristicas()) {
                Caracteristica caracteristica = new Caracteristica(caracteristicaDto.getNombre(),
                        caracteristicaDto.getValor());
                this.caracteristicaRepository.save(caracteristica);
                listaCaracteristicas.add(caracteristica);
            }

            Mascota mascota = new Mascota(
                    mascotaRequest.getNombre(),
                    mascotaRequest.getApodo(),
                    mascotaRequest.getEdad(),
                    mascotaRequest.getSexo(),
                    mascotaRequest.getDescripcion(),
                    mascotaRequest.getEstado(),
                    mascotaRequest.getClaseAnimal(),
                    mascotaRequest.getFoto(),
                    persona.get(),
                    listaCaracteristicas);

            this.mascotaRepository.save(mascota);
            return ResponseEntity.ok(mascota);
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }
    }
}
