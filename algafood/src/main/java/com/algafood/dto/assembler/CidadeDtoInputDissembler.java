package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Estado;
import com.algafood.dto.input.CidadeInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeDtoInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDoMainObject(CidadeInput cidadeInput) {
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
        // Para Evitar essa exception (org.springframework.orm.jpa.JpaSystemException: identifier of an instance of
        cidade.setEstado(new Estado());
        modelMapper.map(cidadeInput, cidade);
    }
}