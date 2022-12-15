package com.algafood.dto.assembler;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Estado;
import com.algafood.domain.model.Restaurante;
import com.algafood.dto.input.CidadeInput;
import com.algafood.dto.input.RestauranteInput;
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

    public void copyToDomainObjetct(CidadeInput cidadeInput, Cidade cidade) {
        // Para Evitar essa exception (org.springframework.orm.jpa.JpaSystemException: identifier of an instance of
        cidade.setEstado(new Estado());
        modelMapper.map(cidadeInput, cidade);
    }
}