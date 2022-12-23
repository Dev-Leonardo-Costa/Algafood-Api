package com.algafood.api.controller;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CadastroRestauranteService;
import com.algafood.dto.UsuarioDTO;
import com.algafood.dto.assembler.UsuarioDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/responsaveis")
public class RestauranteResponsavelController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;
    @Autowired
    private UsuarioDTOAssembler usuarioDtoAssembler;

    @GetMapping
    public List<UsuarioDTO> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
        return usuarioDtoAssembler.toCollectionModel(restaurante.getResponsaveis());
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long restauranteId, @PathVariable Long usuarioId){
        cadastroRestaurante.desassociarResponsavel(restauranteId,usuarioId);
    }

    @PutMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long restauranteId, @PathVariable Long usuarioId){
        cadastroRestaurante.associarResponsavel(restauranteId,usuarioId);
    }
}