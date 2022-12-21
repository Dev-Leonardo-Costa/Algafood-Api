package com.algafood.domain.exception;

import java.io.Serial;

public class FormaPagamentoNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public FormaPagamentoNaoEncontradaException(String message) {
		super( message);
	}

	public FormaPagamentoNaoEncontradaException(Long formaPagamentoId) {
		this(String.format("Não existe um cadastro de forma pagamento com código %d", formaPagamentoId));
	}
}
