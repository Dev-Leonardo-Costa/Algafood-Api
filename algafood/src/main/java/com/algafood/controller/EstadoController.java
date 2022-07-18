package com.algafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.model.Estado;
import com.algafood.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @Autowired
    private EstadoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estado>> listar(){
        return ResponseEntity.ok().body(service.listar());
    }
}
