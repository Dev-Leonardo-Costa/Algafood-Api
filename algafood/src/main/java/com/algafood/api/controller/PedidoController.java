package com.algafood.api.controller;

import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.model.Pedido;
import com.algafood.domain.model.Usuario;
import com.algafood.domain.repository.PedidoRepository;
import com.algafood.domain.service.EmissaoPedidoService;
import com.algafood.dto.PedidoDTO;
import com.algafood.dto.PedidoResumoDTO;
import com.algafood.dto.assembler.PedidoDTOAssembler;
import com.algafood.dto.assembler.PedidoDTOInputDissembler;
import com.algafood.dto.assembler.PedidoResumoDTOAssembler;
import com.algafood.dto.filter.PedidoFilter;
import com.algafood.dto.input.PedidoInput;
import com.algafood.infrastructure.repository.spec.PedidoSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDTOAssembler pedidoDtoAssembler;

    @Autowired
    private PedidoResumoDTOAssembler pedidoResumoDTOAssembler;

    @Autowired
    private PedidoDTOInputDissembler pedidoDTOInputDissembler;

    @GetMapping
    public Page<PedidoResumoDTO> pesquisar(@PageableDefault(size = 10) PedidoFilter filtro, Pageable pageable){
        Page<Pedido> pedidoPage = pedidoRepository.findAll(PedidoSpecs.usandoFiltro(filtro), pageable);
        List<PedidoResumoDTO> pedidoResumoDTO =  pedidoResumoDTOAssembler.toCollectionModel(pedidoPage.getContent());
        return new PageImpl<>(pedidoResumoDTO, pageable, pedidoPage.getTotalElements());
    }

    @GetMapping("/{codigoPedido}")
    public PedidoDTO buscar(@PathVariable String codigoPedido){
        Pedido pedido = emissaoPedido.buscarPedidoOuFalhar(codigoPedido);
        return pedidoDtoAssembler.toModelDTO(pedido);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO adicionar(@RequestBody @Valid PedidoInput pedidoInput){
        try {
            Pedido novoPedido = pedidoDTOInputDissembler.toDoMainObject(pedidoInput);

            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);

            novoPedido = emissaoPedido.emitir(novoPedido);
            return  pedidoDtoAssembler.toModelDTO(novoPedido);
        }catch (EntidadeNaoEncontradaException ex){
            throw new NegocioException(ex.getMessage(), ex);
        }
    }
}