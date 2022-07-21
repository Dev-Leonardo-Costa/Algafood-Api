package com.algafood.jpa.formapamento;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentoRepository;

public class ExclusaoFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);
		
		System.out.println("\nforma de pagamentos ");
		for(FormaPagamento pagamentos : formaPagamentos.buscarTodas()) {
			System.out.println("ID "+ pagamentos.getId() +" "+ pagamentos.getDescricao());
		}
		
		formaPagamentos.remover(formaPagamentos.buscarPorId(1L));
		
		System.out.println("\ndepois da exclusao, todas as forma de pagamento atual");
		for(FormaPagamento pagamentos : formaPagamentos.buscarTodas()) {
			System.out.println("ID "+ pagamentos.getId() +" "+  pagamentos.getDescricao());
		}
		
	}
}
