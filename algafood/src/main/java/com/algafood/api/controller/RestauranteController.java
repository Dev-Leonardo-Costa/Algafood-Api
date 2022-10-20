package com.algafood.api.controller;

import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CadastroCozinhaService;
import com.algafood.domain.service.CadastroRestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;
    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping
    public List<Restaurante> buscarTodos() {
        return cadastroRestaurante.buscarTodos();
    }

    @GetMapping("/{restauranteId}")
    public Restaurante buscarPorId(@PathVariable Long restauranteId) {
        return cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {
        try {
            Long cozinhaId = restaurante.getCozinha().getId();
            Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
            restaurante.setCozinha(cozinha);
            return cadastroRestaurante.salvar(restaurante);
        } catch (RestauranteNaoEncontradoException ex) {
            throw new NegocioException(ex.getMessage());
        }

    }

    @DeleteMapping("/{restauranteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long restauranteId) {
        cadastroRestaurante.excluir(restauranteId);
    }

    @PutMapping("/{restauranteId}")
    public Restaurante atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        Restaurante restauranteAtual = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
        BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro", "produtos");
        try {
            return cadastroRestaurante.salvar(restauranteAtual);
        } catch (EntidadeNaoEncontradaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

//    @PatchMapping("/{restauranteId}")
//    public Restaurante atualizarParcial(@PathVariable Long restauranteId,
//                                        @RequestBody Map<String, Object> campos) {
//        Restaurante restauranteAtual = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
//
//        merge(campos, restauranteAtual);
//
//        return atualizar(restauranteId, restauranteAtual);
//    }

//	@PatchMapping("/{restauranteId}")
//	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId,
//			@RequestBody Map<String, Object> campos) {
//
//		Optional<Restaurante> restauranteAtual = cadastroRestaurante.buscarPorId(restauranteId);
//
//		if (restauranteAtual.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//
//		merge(campos, restauranteAtual);
//
//		return atualizar(restauranteId, restauranteAtual);
//	}

//	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
//				
//		dadosOrigem.forEach((nomePropriedade, valorPropiedade) -> {
//			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
//			field.setAccessible(true);
//
//			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
//			
////			System.out.println(nomePropriedade + " = " + valorPropiedade + " = " + novoValor );
//
//			ReflectionUtils.setField(field, restauranteDestino, novoValor);
//		});
//	}

}
