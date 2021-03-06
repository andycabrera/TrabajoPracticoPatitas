package com.slowcode.rescatedepatitas.mascotas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.slowcode.rescatedepatitas.mascotas.entidades.Adopcion;
import com.slowcode.rescatedepatitas.mascotas.entidades.IntencionAdopcion;
import com.slowcode.rescatedepatitas.mascotas.entidades.PreguntaRespuesta;
import com.slowcode.rescatedepatitas.mascotas.entidades.Publicacion;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.PreguntaRespuestaDto;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.RequestIntencionAdopcion;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.RequestPublicarAdopcion;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.RequestReportar;
import com.slowcode.rescatedepatitas.mascotas.repositories.AdopcionRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.IntencionAdopcionRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.MascotaRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.PreguntaRespuestaRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.PublicacionRepository;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;
import com.slowcode.rescatedepatitas.personas.repositories.PersonaRepository;
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
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    PreguntaRespuestaRepository preguntaRespuestaRepository;

    @Autowired
    AdopcionRepository adopcionRepository;

    @Autowired
    IntencionAdopcionRepository intencionAdopcionRepository;

    @PostMapping("/reportar")
    public ResponseEntity<Object> reportarMascota(@RequestBody RequestReportar request) {
        System.out.println("Persona id : " + request.getIdPersona());

        Optional<Persona> persona = this.personaRepository.findById(request.getIdPersona());

        if (persona.isPresent()) {

            Publicacion publicacion = new Publicacion(request.getEstadoMascotaEncontrada(), request.getLongitud(),
                    request.getLatitud(),
                    request.getEstadoPublicacion(), persona.get(), request.getNombreMascota(),
                    request.getDescripcionFisica(),
                    request.getFoto());

            this.publicacionRepository.save(publicacion);

            return ResponseEntity.ok(persona);

        } else {
            return new Tools().error("Persona no encontrada.");
        }

    }

    @PostMapping("/publicarAdopcion")
    public ResponseEntity<Object> publicarMascotaAdopcion(@RequestBody RequestPublicarAdopcion request) {

        try {
            Optional<Persona> persona = this.personaRepository.findById(request.getIdPersona());
            List<PreguntaRespuesta> listPreguntas = new ArrayList<>();
            Adopcion adopcion = new Adopcion();

            if (persona.isPresent()) {


                adopcion.setPersona(persona.get());
                // adopcion.setListaPreguntaRespuesta(listPreguntas);
                adopcion.setFoto(request.getFoto());

                this.adopcionRepository.save(adopcion);


                for (PreguntaRespuestaDto preguntaRespuesta : request.getListaPreguntas()) {
                    PreguntaRespuesta preguntaResp = new PreguntaRespuesta(preguntaRespuesta.getPregunta(),
                            preguntaRespuesta.getRespuesta());

                            preguntaResp.setAdopcion(adopcion);
                    this.preguntaRespuestaRepository.save(preguntaResp);
                    listPreguntas.add(preguntaResp);
                }

                return ResponseEntity.ok(adopcion);
            } else {
                return new Tools().error("Persona no encontrada.");
            }
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }

    }

    @PostMapping("/intencionAdopcion")
    public ResponseEntity<Object> publicarIntencionAdopcion(@RequestBody RequestIntencionAdopcion request) {

        try {
            Optional<Persona> persona = this.personaRepository.findById(request.getIdPersona());
            List<PreguntaRespuesta> listPreguntas = new ArrayList<>();
            IntencionAdopcion adopcion = new IntencionAdopcion();

            if (persona.isPresent()) {

                

                adopcion.setPersona(persona.get());
                // adopcion.setListaPreguntaRespuesta(listPreguntas);

                this.intencionAdopcionRepository.save(adopcion);

                for (PreguntaRespuestaDto preguntaRespuesta : request.getListaPreguntas()) {
                    PreguntaRespuesta preguntaResp = new PreguntaRespuesta(preguntaRespuesta.getPregunta(),
                            preguntaRespuesta.getRespuesta());

                    preguntaResp.setIntencionAdopcion(adopcion);
                    this.preguntaRespuestaRepository.save(preguntaResp);
                    listPreguntas.add(preguntaResp);
                }
        
                return ResponseEntity.ok(adopcion);
            } else {
                return new Tools().error("Persona no encontrada.");
            }
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }

    }

    @GetMapping("/publicacion")
    public ResponseEntity<Object> getPublicaciones() {

        try {


                List<Publicacion> lista = this.publicacionRepository.findAll();

                return ResponseEntity.ok(lista);
           
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }

    }

    @GetMapping("/publicarAdopcion")
    public ResponseEntity<Object> getPublicarAdopcion() {

        try {


                List<Adopcion> lista = this.adopcionRepository.findAll();

                return ResponseEntity.ok(lista);
          
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }

    }

    @GetMapping("/intencionAdopcion")
    public ResponseEntity<Object> getIntencionAdopcion() {

        try {

            List<IntencionAdopcion> lista = this.intencionAdopcionRepository.findAll();

            return ResponseEntity.ok(lista);
  
        } catch (Exception e) {
            return new Tools().error(e.getMessage());
        }

    }
}
