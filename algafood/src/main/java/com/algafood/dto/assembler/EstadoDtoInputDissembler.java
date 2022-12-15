package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Estado;
import com.algafood.domain.model.Restaurante;
import com.algafood.dto.input.CidadeInput;
import com.algafood.dto.input.EstadoInput;
import com.algafood.dto.input.RestauranteInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoDtoInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Estado toDoMainObject(EstadoInput estadoInput) {
        return modelMapper.map(estadoInput, Estado.class);
    }

    public void copyToDomainObjetct(EstadoInput estadoInput, Estado estado) {
        modelMapper.map(estadoInput, estado);
    }
}