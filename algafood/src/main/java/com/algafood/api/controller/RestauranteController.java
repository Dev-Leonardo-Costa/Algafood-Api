package com.algafood.api.controller;

import com.algafood.domain.exception.*;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CadastroCozinhaService;
import com.algafood.domain.service.CadastroRestauranteService;
import com.algafood.dto.CozinhaDTO;
import com.algafood.dto.RestauranteDTO;
import com.algafood.dto.input.RestauranteInput;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;
    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Autowired
    private SmartValidator validator;

    @GetMapping
    public List<RestauranteDTO> listar() {
        return RestauranteDTO.toCollectionModel(cadastroRestaurante.buscarTodos());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteDTO buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
        return RestauranteDTO.toModelDTO(restaurante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteDTO adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
        try {
            Restaurante restaurante = RestauranteDTO.toDoMainObject(restauranteInput);

            return RestauranteDTO.toModelDTO(cadastroRestaurante.salvar(restaurante));
        } catch (RestauranteNaoEncontradoException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

//    @DeleteMapping("/{restauranteId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void remover(@PathVariable Long restauranteId) {
//        cadastroRestaurante.excluir(restauranteId);
//    }

    @PutMapping("/{restauranteId}")
    public RestauranteDTO atualizar(@PathVariable Long restauranteId, @Valid @RequestBody RestauranteInput restauranteInput) {
        try {

            Restaurante restaurante = RestauranteDTO.toDoMainObject(restauranteInput);
            Restaurante restauranteAtual = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
            BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro", "produtos");
            return RestauranteDTO.toModelDTO(cadastroRestaurante.salvar(restauranteAtual));

        } catch (CozinhaNaoEncontradaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

//    @PatchMapping("/{restauranteId}")
//    public RestauranteDTO atualizarParcial(@PathVariable Long restauranteId,
//                                           @RequestBody Map<String, Object> campos, HttpServletRequest request) {
//        Restaurante restauranteAtual = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
//
//        merge(campos, restauranteAtual, request);
//        validate(restauranteAtual, "restaurante");
//
//        return atualizar(restauranteId, restauranteAtual);
//    }
//
//    private void validate(Restaurante restaurante, String objectName) {
//        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(restaurante, objectName);
//        validator.validate(restaurante, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            throw new ValidadorException(bindingResult);
//        }
//    }
//
//    private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino,
//                       HttpServletRequest request) {
//        ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(request);
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//
//            Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
//
//            dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
//                Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
//                field.setAccessible(true);
//
//                Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
//
//                ReflectionUtils.setField(field, restauranteDestino, novoValor);
//            });
//        } catch (IllegalArgumentException e) {
//            Throwable rootCause = ExceptionUtils.getRootCause(e);
//            throw new HttpMessageNotReadableException(e.getMessage(), rootCause, serverHttpRequest);
//        }
//    }

}