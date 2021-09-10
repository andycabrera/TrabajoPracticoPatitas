package com.slowcode.rescatedepatitas.mascotas.controllers;

import java.util.Optional;

import com.slowcode.rescatedepatitas.mascotas.entidades.Mascota;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MascotaPersonaRequest;
import com.slowcode.rescatedepatitas.mascotas.entidades.dto.MascotaRequest;
import com.slowcode.rescatedepatitas.mascotas.repositories.MascotaRepository;
import com.slowcode.rescatedepatitas.mascotas.repositories.MediosRepository;
import com.slowcode.rescatedepatitas.personas.entidades.Contacto;
import com.slowcode.rescatedepatitas.personas.entidades.Documento;
import com.slowcode.rescatedepatitas.personas.entidades.MedioComunicacion;
import com.slowcode.rescatedepatitas.personas.entidades.Persona;
import com.slowcode.rescatedepatitas.personas.repositories.DocumentoRepository;
import com.slowcode.rescatedepatitas.personas.repositories.PersonaRepository;
import com.slowcode.rescatedepatitas.utils.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    
}
