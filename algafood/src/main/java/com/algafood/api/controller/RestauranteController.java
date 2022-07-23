package com.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
import com.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping
	public List<Restaurante> buscarTodos() {
		return restauranteRepository.buscarTodos();
	}

	@GetMapping("/{restaurante_id}")
	public Restaurante buscarPorId(@PathVariable Long restaurante_id) {
		return cadastroRestaurante.buscarPorId(restaurante_id);
	}
}
