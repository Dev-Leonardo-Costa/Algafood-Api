package com.algafood.jpa.permissao;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;

public class InclusaoPermissaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);

		System.out.println("\nAntes da inclusao");
		for (Permissao todasPermissao : permissoes.buscarTodas()) {
			System.out.println(todasPermissao.getNome());
		}

		Permissao permissao = new Permissao();
		permissao.setNome("TESTANDO");
		permissao.setDescricao("teste");

		permissoes.adicionar(permissao);

		System.out.println("\nDepois da inclusao");
		for (Permissao todasPermissao : permissoes.buscarTodas()) {
			System.out.println(todasPermissao.getNome());
		}
	}
}
