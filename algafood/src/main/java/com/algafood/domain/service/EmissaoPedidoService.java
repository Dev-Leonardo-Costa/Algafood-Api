package com.algafood.domain.service;

import com.algafood.domain.exception.PedidoNaoEncontradaException;
import com.algafood.domain.model.Pedido;
import com.algafood.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmissaoPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    public Pedido buscarPedidoOuFalhar(Long pedidoId){
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNaoEncontradaException(pedidoId));
    }

}

