package com.algafood.api.controller;

import com.algafood.domain.model.Pedido;
import com.algafood.domain.repository.PedidoRepository;
import com.algafood.domain.service.EmissaoPedidoService;
import com.algafood.dto.PedidoDTO;
import com.algafood.dto.PedidoResumoDTO;
import com.algafood.dto.assembler.PedidoDTOAssembler;
import com.algafood.dto.assembler.PedidoResumoDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDTOAssembler pedidoDtoAssembler;

    @Autowired
    private PedidoResumoDTOAssembler pedidoResumoDTOAssembler;

    @GetMapping
    public List<PedidoResumoDTO> listar(){
        List<Pedido> todosPedidos = pedidoRepository.findAll();
        return pedidoResumoDTOAssembler.toCollectionModel(todosPedidos);
    }

    @GetMapping("/{pedidoId}")
    public PedidoDTO buscar(@PathVariable Long pedidoId){
        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(pedidoId);
        return pedidoDtoAssembler.toModelDTO(pedido);
    }
}