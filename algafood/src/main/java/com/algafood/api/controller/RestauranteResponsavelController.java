package com.algafood.api.controller;

import com.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CadastroCozinhaService;
import com.algafood.domain.service.CadastroRestauranteService;
import com.algafood.dto.RestauranteDTO;
import com.algafood.dto.UsuarioDTO;
import com.algafood.dto.assembler.RestaranteDtoInputDissembler;
import com.algafood.dto.assembler.RestauranteDtoAssembler;
import com.algafood.dto.assembler.UsuarioDtoAssembler;
import com.algafood.dto.input.RestauranteInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/responsaveis")
public class RestauranteResponsavelController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;
    @Autowired
    private UsuarioDtoAssembler usuarioDtoAssembler;

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