package com.algafood.api.controller;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CadastroRestauranteService;
import com.algafood.dto.FormaPagamentoDTO;
import com.algafood.dto.assembler.FormaPagamentoDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/formas-pagamento")
public class RestauranteFormaPagamentoController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private FormaPagamentoDTOAssembler formaPagamentoDtoAssembler;

    @GetMapping
    public List<FormaPagamentoDTO> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
        return formaPagamentoDtoAssembler.toCollectionModel(restaurante.getFormasPagamento());
    }

    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dessasociar(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId){
            cadastroRestaurante.dessasociarFormaPagamento(restauranteId, formaPagamentoId);
    }

    @PutMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long restauranteId, @PathVariable Long formaPagamentoId){
        cadastroRestaurante.associarFormaPagamento(restauranteId, formaPagamentoId);
    }

}