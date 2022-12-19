package com.algafood.dto;

import com.algafood.domain.model.Cidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
public class EnderecoDTO {

    private String cep;
    private String logadouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeResumoDTO cidade;
}
