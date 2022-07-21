package com.algafood.jpa.permissao;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;

public class BuscaPermissaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);

		Permissao permissao = permissoes.buscarPorId(2L);
		System.out.println(permissao.getNome());
	}
}
