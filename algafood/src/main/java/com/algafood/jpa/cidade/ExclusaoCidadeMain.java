package com.algafood.jpa.cidade;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;

public class ExclusaoCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);

		System.out.println("\nAntes");
		for (Cidade c : cidades.buscarTodas()) {
			System.out.println("Cidade > " + c.getNome() + " Estado > " + c.getEstado().getNome());
		}
		
//		cidades.remover(cidades.buscarPorId(1l));;
		
		System.out.println("\nDepois");
		for (Cidade c : cidades.buscarTodas()) {
			System.out.println("Cidade > " + c.getNome() + " Estado > " + c.getEstado().getNome());
		}

	}
}
