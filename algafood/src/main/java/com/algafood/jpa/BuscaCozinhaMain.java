package com.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = cozinhaRepository.buscarPorId(1L);
		
		System.out.println(cozinha.getNome());
	}
}
