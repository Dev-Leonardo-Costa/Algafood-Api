package com.algafood.dto.assembler;

import com.algafood.domain.model.Estado;
import com.algafood.dto.EstadoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EstadoDTO toModelDTO(Estado estado) {
        return modelMapper.map(estado, EstadoDTO.class);
    }

    public List<EstadoDTO> toCollectionModel(List<Estado> estados){
        return estados.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}