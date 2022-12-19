package com.algafood.dto.assembler;

import com.algafood.domain.model.Grupo;
import com.algafood.dto.GrupoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public GrupoDTO toModelDTO(Grupo grupo) {
        return modelMapper.map(grupo, GrupoDTO.class);
    }

    public List<GrupoDTO> toCollectionModel(List<Grupo> grupos){
        return grupos.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}