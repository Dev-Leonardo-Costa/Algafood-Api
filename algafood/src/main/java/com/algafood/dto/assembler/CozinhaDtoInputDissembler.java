package com.algafood.dto.assembler;

import com.algafood.domain.model.Cozinha;
import com.algafood.dto.input.CozinhaInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CozinhaDtoInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDoMainObject(CozinhaInput cozinhaInput) {
        return modelMapper.map(cozinhaInput, Cozinha.class);
    }

    public void copyToDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha) {
        modelMapper.map(cozinhaInput, cozinha);
    }
}