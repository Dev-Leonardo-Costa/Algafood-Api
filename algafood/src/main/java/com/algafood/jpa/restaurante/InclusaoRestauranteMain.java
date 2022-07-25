package com.algafood.jpa.restaurante;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		Cozinha cozinha = cozinhas.buscarPorId(1L);
		
		
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("comida brasileira");
		restaurante.setTaxaFrete(new BigDecimal(15));
		restaurante.setCozinha(cozinha);
		
		restaurantes.adicionar(restaurante);
		System.out.println(restaurantes.buscarTodos());
	}
}
