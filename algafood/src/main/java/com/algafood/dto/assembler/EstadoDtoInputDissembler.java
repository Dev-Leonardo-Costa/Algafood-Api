package com.algafood.dto.assembler;

import com.algafood.domain.model.Estado;
import com.algafood.dto.input.EstadoInput;
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

    public void copyToDomainObject(EstadoInput estadoInput, Estado estado) {
        modelMapper.map(estadoInput, estado);
    }
}