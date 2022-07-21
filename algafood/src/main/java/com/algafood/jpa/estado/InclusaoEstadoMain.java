package com.algafood.jpa.estado;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

public class InclusaoEstadoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		Estado estado = new Estado();
		estado.setNome("Italia");
		
		estado = estados.adicionar(estado);

		System.out.printf("%d - %s\n", estado.getId(), estado.getNome());
	}
}
