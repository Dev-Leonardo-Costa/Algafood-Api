package com.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Restaurante buscarPorId(Long restauranteId) {
		return restauranteRepository.buscarPorId(restauranteId);
	}
	
	public List<Restaurante> buscarTodos(){
		return restauranteRepository.buscarTodos();
	}
}
