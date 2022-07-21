package com.algafood.jpa.cidade;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;
import com.algafood.domain.repository.EstadoRepository;

public class InclusaoCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Maracanaú");
		cidade.setEstado(estados.buscaPorId(1L));
		cidades.adicionar(cidade);
		
		for(Cidade c : cidades.buscarTodas() ) {
			System.out.println("Cidade > "+ c.getNome() +" Estado > "+ c.getEstado().getNome());
		}
		
	}
}
