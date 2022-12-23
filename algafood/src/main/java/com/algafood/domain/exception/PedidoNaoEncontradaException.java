package com.algafood.domain.exception;

import java.io.Serial;

public class PedidoNaoEncontradaException extends EntidadeNaoEncontradaException {

	@Serial
	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradaException(String message) {
		super( message);
	}

	public PedidoNaoEncontradaException(Long pedidoId) {
		this(String.format("Não existe um pedido com código %d", pedidoId));
	}
}
