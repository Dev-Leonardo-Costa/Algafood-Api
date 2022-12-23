package com.algafood.dto.assembler;

import com.algafood.domain.model.Pedido;
import com.algafood.dto.PedidoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PedidoDTO toModelDTO(Pedido pedido) {
        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public List<PedidoDTO> toCollectionModel(List<Pedido> pedidos){
        return pedidos.stream()
                .map(pedido -> toModelDTO(pedido))
                .collect(Collectors.toList());
    }
}