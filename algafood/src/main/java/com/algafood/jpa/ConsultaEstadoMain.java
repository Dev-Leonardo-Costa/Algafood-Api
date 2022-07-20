package com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

public class ConsultaEstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		List<Estado> todosEstados = estados.buscarTodos();
		
		todosEstados.stream().filter(estado -> estado.getClass().isArray());
		todosEstados.forEach(estado -> System.out.println(estado.getNome()));
		
//		for (Estado estado : todosEstados) {
//			System.out.println(estado.getNome());
//		}
	}
}
