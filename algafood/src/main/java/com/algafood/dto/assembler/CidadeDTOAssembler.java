package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.dto.CidadeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CidadeDTO toModelDTO(Cidade cidade) {
        return modelMapper.map(cidade, CidadeDTO.class);
    }

    public List<CidadeDTO> toCollectionModel(List<Cidade> cidades){
        return cidades.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}