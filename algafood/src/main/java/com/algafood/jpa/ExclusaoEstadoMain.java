package com.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.repository.EstadoRepository;

public class ExclusaoEstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		System.out.println("\n"+ estados.buscarTodos()+"\n");
		
		estados.remover(estados.buscaPorId(1L));
		
		System.out.println("\n Atual "+ estados.buscarTodos()+"\n");
	}	
}
