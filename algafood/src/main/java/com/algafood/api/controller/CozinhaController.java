package com.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.api.model.CozinhaXmlWrapper;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> buscarTodas(){
		return cozinhaRepository.buscarTodas();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhaXmlWrapper buscarTodasXml(){
		return new CozinhaXmlWrapper(cozinhaRepository.buscarTodas());
	}
	
	@GetMapping("/{cozinhaId}")
	public Cozinha buscarPorId(@PathVariable Long cozinhaId) {	
		return cozinhaRepository.buscarPorId(cozinhaId);
	}
}
