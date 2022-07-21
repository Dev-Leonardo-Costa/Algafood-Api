package com.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<Estado> buscarTodos() {
		return estadoRepository.buscarTodos();
	}

	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscarPorId(@PathVariable Long estadoId) {
		Estado estado = estadoRepository.buscaPorId(estadoId);

		if (estado != null) {
			return ResponseEntity.ok().body(estado);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

}
