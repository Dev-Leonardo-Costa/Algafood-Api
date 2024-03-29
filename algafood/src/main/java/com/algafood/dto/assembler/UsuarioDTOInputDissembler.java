package com.algafood.dto.assembler;

import com.algafood.domain.model.Usuario;
import com.algafood.dto.input.UsuarioInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDTOInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Usuario toDoMainObject(UsuarioInput usuarioInput) {
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario) {
        modelMapper.map(usuarioInput, usuario);
    }
}