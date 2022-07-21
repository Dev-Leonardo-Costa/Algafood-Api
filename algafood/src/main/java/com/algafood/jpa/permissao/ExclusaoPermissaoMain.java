package com.algafood.jpa.permissao;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;

public class ExclusaoPermissaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);
		
		System.out.println("\nAntes");
		for(Permissao todasPermissao : permissoes.buscarTodas()) {
			System.out.println(todasPermissao.getNome());
		}
		
		Permissao permissao = permissoes.buscarPorId(2L);
		permissoes.remover(permissao);
		
		System.out.println("\nDepois");
		for(Permissao todasPermissao : permissoes.buscarTodas()) {
			System.out.println(todasPermissao.getNome());
		}
	}
}
