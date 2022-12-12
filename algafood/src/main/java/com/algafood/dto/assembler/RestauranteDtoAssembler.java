package com.algafood.dto.assembler;

import com.algafood.domain.model.Restaurante;
import com.algafood.dto.CozinhaDTO;
import com.algafood.dto.RestauranteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public RestauranteDTO toModelDTO(Restaurante restaurante) {
        return modelMapper.map(restaurante, RestauranteDTO.class);
    }
    public List<RestauranteDTO> toCollectionModel(List<Restaurante> restaurantes){
        return restaurantes.stream()
                .map(this::toModelDTO)
                .collect(Collectors.toList());
    }
}