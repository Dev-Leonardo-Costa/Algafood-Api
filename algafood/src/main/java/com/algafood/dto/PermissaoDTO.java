package com.algafood.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class PermissaoDTO {

    private Long id;
    private String nome;
    private String descricao;

}
