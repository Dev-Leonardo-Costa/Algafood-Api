package com.algafood.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CozinhaDTO {

    private Long cozinhaId;
    private String cozinhaNome;

}