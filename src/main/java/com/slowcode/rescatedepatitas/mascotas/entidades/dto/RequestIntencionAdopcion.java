package com.slowcode.rescatedepatitas.mascotas.entidades.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestIntencionAdopcion {

    private List<PreguntaRespuestaDto> listaPreguntas;
    private Long idPersona;

}
