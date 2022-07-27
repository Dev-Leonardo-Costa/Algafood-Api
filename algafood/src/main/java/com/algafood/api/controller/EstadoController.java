package com.algafood.api.controller;

import java.util.List;

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
import com.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private CadastroEstadoService cadastroEstados;

	@GetMapping
	public List<Estado> buscarTodos() {
		return cadastroEstados.buscarTodos();
	}

	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscarPorId(@PathVariable Long estadoId) {
		Estado estado = cadastroEstados.buscarPorId(estadoId);

		if (estado != null) {
			return ResponseEntity.ok(estado);
		}

//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {
		return cadastroEstados.salvar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado){
		Estado estadoAtual = cadastroEstados.buscarPorId(estadoId);
		
		if(estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			
			estadoAtual = cadastroEstados.salvar(estadoAtual);
			return ResponseEntity.ok(estadoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> excluir(@PathVariable Long estadoId) {
		try {
			cadastroEstados.excluir(estadoId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		}
	}

}
