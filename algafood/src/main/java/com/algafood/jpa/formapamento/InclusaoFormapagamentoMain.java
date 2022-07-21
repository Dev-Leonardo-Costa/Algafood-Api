package com.algafood.jpa.formapamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentoRepository;

public class InclusaoFormapagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		FormaPagamentoRepository formaPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);

		FormaPagamento pagamento = new FormaPagamento();
		pagamento.setDescricao("FIADO");
		formaPagamentos.adicionar(pagamento);

		for (FormaPagamento todasFormaPagamento : formaPagamentos.buscarTodas()) {
			System.out.println(todasFormaPagamento.getDescricao());
		}
	}
}
