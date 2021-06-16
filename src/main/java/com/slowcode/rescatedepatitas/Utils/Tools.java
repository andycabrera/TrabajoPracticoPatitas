package com.slowcode.rescatedepatitas.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Tools {
    
    public Tools(){}

    public ResponseEntity<Object> error(String mensaje){
        Map<String, String> error = new HashMap<String,String>();
        error.put("error", mensaje);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
