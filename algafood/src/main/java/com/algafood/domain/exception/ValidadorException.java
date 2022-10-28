package com.algafood.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@AllArgsConstructor
@Getter
public class ValidadorException extends  RuntimeException{

    private BindingResult bindingResult;

}
