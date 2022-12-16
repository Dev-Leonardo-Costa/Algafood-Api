package com.algafood.domain.service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.FormaPagamentoNaoEncontradaException;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroFormaPagamentoService {

    private static final String MSG_FORMA_PAGAMENTO_EM_USO = "Forma pagamento %d não pode ser removida: Encontra-se em uso";
    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Transactional
    public List<FormaPagamento> buscarTodos() {
        return formaPagamentoRepository.findAll();
    }

    @Transactional
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    @Transactional
    public void excluir(Long formaPagamentoId) {
        try {
            formaPagamentoRepository.deleteById(formaPagamentoId);
            formaPagamentoRepository.flush();

        } catch (EmptyResultDataAccessException ex) {
            throw new FormaPagamentoNaoEncontradaException(formaPagamentoId);

        } catch (DataIntegrityViolationException ex) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_FORMA_PAGAMENTO_EM_USO, formaPagamentoId));
        }
    }

    public FormaPagamento buscarFormaPagamentoOuFalhar(Long formaPagamentoId) {
        return formaPagamentoRepository.findById(formaPagamentoId)
                .orElseThrow(() -> new FormaPagamentoNaoEncontradaException(formaPagamentoId));
    }
}
