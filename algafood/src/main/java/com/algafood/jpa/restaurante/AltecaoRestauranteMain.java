package com.algafood.jpa.restaurante;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;

public class AltecaoRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		for(Restaurante todos : restaurantes.buscarTodos()) {
			System.out.println(todos.getNome());
		}
		
		Restaurante restaurante = new Restaurante();
	    restaurante = restaurantes.buscarPorId(1L);
	    restaurante.getCozinha().getId();
		restaurante.setNome("leonardo testando");
		
		restaurantes.adicionar(restaurante);
		System.out.println("\n\nAlterado o restarante com código " + restaurante.getId());
		for(Restaurante todos : restaurantes.buscarTodos()) {
			System.out.println(todos.getNome());
		}
	}
}
