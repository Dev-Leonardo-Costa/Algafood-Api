package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Estado;
import com.algafood.domain.model.Grupo;
import com.algafood.dto.input.CidadeInput;
import com.algafood.dto.input.GrupoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoDtoInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Grupo toDoMainObject(GrupoInput grupoInput) {
        return modelMapper.map(grupoInput, Grupo.class);
    }

    public void copyToDomainObject(GrupoInput grupoInput, Grupo grupo) {
        modelMapper.map(grupoInput, grupo);
    }
}