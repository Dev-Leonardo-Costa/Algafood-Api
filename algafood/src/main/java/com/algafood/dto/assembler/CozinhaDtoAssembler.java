package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Cozinha;
import com.algafood.dto.CidadeDTO;
import com.algafood.dto.CozinhaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CozinhaDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CozinhaDTO toModelDTO(Cozinha cozinha) {
        return modelMapper.map(cozinha, CozinhaDTO.class);
    }

    public List<CozinhaDTO> toCollectionModel(List<Cozinha> cozinhas){
        return cozinhas.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}