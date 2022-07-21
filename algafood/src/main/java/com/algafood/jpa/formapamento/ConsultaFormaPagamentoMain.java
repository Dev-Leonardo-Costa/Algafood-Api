package com.algafood.jpa.formapamento;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		FormaPagamentoRepository formaPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);

		List<FormaPagamento> todasFormaPagamentos = formaPagamentos.buscarTodas();

		for (FormaPagamento formaPagamento : todasFormaPagamentos) {
			System.out.println(formaPagamento.getDescricao());
		}
	}
}
