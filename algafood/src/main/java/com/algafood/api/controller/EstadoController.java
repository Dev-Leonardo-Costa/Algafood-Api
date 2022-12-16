package com.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import com.algafood.dto.EstadoDTO;
import com.algafood.dto.assembler.EstadoDtoAssembler;
import com.algafood.dto.assembler.EstadoDtoInputDissembler;
import com.algafood.dto.input.EstadoInput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;
import com.algafood.domain.service.CadastroEstadoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private CadastroEstadoService cadastroEstados;

	@Autowired
	private EstadoDtoAssembler estadoDtoAssembler;

	@Autowired
	private EstadoDtoInputDissembler estadoDtoInputDissembler;

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<EstadoDTO> listar() {
		List<Estado> todosEstados = cadastroEstados.buscarTodos();
		return estadoDtoAssembler.toCollectionModel(todosEstados);
	}

	@GetMapping("/{estadoId}")
	public EstadoDTO buscar(@PathVariable Long estadoId) {
		Estado estado = cadastroEstados.buscarEstadoOuFalhar(estadoId);
		return estadoDtoAssembler.toModelDTO(estado);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoDTO adicionar(@RequestBody @Valid EstadoInput estadoInput) {
		Estado estado = estadoDtoInputDissembler.toDoMainObject(estadoInput);
		estado = cadastroEstados.salvar(estado);
		return estadoDtoAssembler.toModelDTO(estado);
	}

	@PutMapping("/{estadoId}")
	public EstadoDTO atualizar(@PathVariable Long estadoId, @RequestBody @Valid EstadoInput estadoInput) {
		Estado estadoAtual = cadastroEstados.buscarEstadoOuFalhar(estadoId);
		estadoDtoInputDissembler.copyToDomainObjetct(estadoInput, estadoAtual);
		estadoAtual = cadastroEstados.salvar(estadoAtual);
		return estadoDtoAssembler.toModelDTO(estadoAtual);
	}

	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		cadastroEstados.excluir(estadoId);
	}

}
