package com.algafood.dto.assembler;

import com.algafood.domain.model.Produto;
import com.algafood.dto.ProdutoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDTO toModelDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> toCollectionModel(List<Produto> produtos){
        return produtos.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}