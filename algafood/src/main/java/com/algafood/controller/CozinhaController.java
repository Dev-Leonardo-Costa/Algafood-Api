package com.algafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.model.Cozinha;
import com.algafood.model.CozinhaXmlWrapper;
import com.algafood.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaService service;
    
    @GetMapping
    public ResponseEntity<List<Cozinha>> listar(){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public  CozinhaXmlWrapper listarXml(){
        return new CozinhaXmlWrapper(service.listar());
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscarPorId(@PathVariable Long cozinhaId){
        return ResponseEntity.ok().body(service.buscarPorId(cozinhaId));
    }
}
