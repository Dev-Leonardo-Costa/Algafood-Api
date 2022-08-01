package com.algafood.api.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;
import com.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CadastroCidadeService cadastroCidades;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping
	public List<Cidade> buscar() {
		return cidadeRepository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Long cidadeId) {

		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);

		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
		try {
			cidade = cadastroCidades.salvar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeId) {
		try {
			cadastroCidades.excluir(cidadeId);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PutMapping("/{cidadeId}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);

		if (cidadeAtual.isPresent()) {
			BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");

			Cidade cidadeSalva = cadastroCidades.salvar(cidadeAtual.get());
			return ResponseEntity.ok(cidadeSalva);
		}

		return ResponseEntity.notFound().build();
	}
}
