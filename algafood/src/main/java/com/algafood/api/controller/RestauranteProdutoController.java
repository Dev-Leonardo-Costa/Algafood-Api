package com.algafood.api.controller;

import com.algafood.domain.model.Produto;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CadastroProdutoService;
import com.algafood.domain.service.CadastroRestauranteService;
import com.algafood.dto.ProdutoDTO;
import com.algafood.dto.assembler.ProdutoDTOAssembler;
import com.algafood.dto.assembler.ProdutoDTOInputDissembler;
import com.algafood.dto.input.ProdutoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class RestauranteProdutoController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private CadastroProdutoService cadastroProduto;

    @Autowired
    private ProdutoDTOAssembler produtoDtoAssembler;

    @Autowired
    private ProdutoDTOInputDissembler produtoDtoInputDissembler;

    @GetMapping("/{produtoId}")
    public ProdutoDTO buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
        Produto produto = cadastroProduto.buscarProdutoOuFalhar(restauranteId, produtoId);
        return produtoDtoAssembler.toModelDTO(produto);
    }

    @GetMapping
    public List<ProdutoDTO> listar(@PathVariable Long restauranteId, @RequestParam(required = false) boolean incluirInativo) {
        Restaurante restaurante = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
        List<Produto> todosProdutos = null;
        if (incluirInativo){
            todosProdutos = cadastroProduto.buscarTodos(restaurante);
        }else {
            todosProdutos = cadastroProduto.buscarAtivos(restaurante);
        }

        return produtoDtoAssembler.toCollectionModel(todosProdutos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO adicionar(@PathVariable Long restauranteId, @RequestBody @Valid ProdutoInput produtoInput) {
        Restaurante restaurante = cadastroRestaurante.buscarRestauranteOuFalhar(restauranteId);
        Produto produto = produtoDtoInputDissembler.toDoMainObject(produtoInput);
        produto.setRestaurante(restaurante);
        produto = cadastroProduto.salvar(produto);
        return produtoDtoAssembler.toModelDTO(produto);
    }

    @PutMapping("/{produtoId}")
    public ProdutoDTO atualizar(@PathVariable Long restauranteId,
                                @PathVariable Long produtoId, @RequestBody @Valid ProdutoInput produtoInput) {

        Produto produtoAtual = cadastroProduto.buscarProdutoOuFalhar(restauranteId, produtoId);
        produtoDtoInputDissembler.copyToDomainObject(produtoInput, produtoAtual);

        produtoAtual = cadastroProduto.salvar(produtoAtual);
        return produtoDtoAssembler.toModelDTO(produtoAtual);
    }
}