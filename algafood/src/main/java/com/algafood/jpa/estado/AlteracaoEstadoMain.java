package com.algafood.jpa.estado;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

public class AlteracaoEstadoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		System.out.println("\n Lista anterior "+ estados.buscarTodos()+ "\n");
		
		Estado estado = new Estado();
		estado.setId(1l);
		estado.setNome("Caucaia");
		
		estados.adicionar(estado);
		
		System.out.println("\n Lista atual "+ estados.buscarTodos()+ "\n");
	}
}
