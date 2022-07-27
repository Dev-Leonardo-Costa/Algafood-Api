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
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.service.CadastroCozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CadastroCozinhaService cadastroCozinhas;

	@GetMapping
	public List<Cozinha> buscarTodas() {
		return cadastroCozinhas.buscarTodas();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscarPorId(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cadastroCozinhas.buscarPorId(cozinhaId);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody Cozinha cozinha) {
		return cadastroCozinhas.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {

		Cozinha cozinhaAtual = cadastroCozinhas.buscarPorId(cozinhaId);

		if (cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

			cadastroCozinhas.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}

		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<?> excluir(@PathVariable Long cozinhaId) {
		try {
			cadastroCozinhas.excluir(cozinhaId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		}
	}
}
