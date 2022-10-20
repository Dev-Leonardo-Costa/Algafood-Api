package com.algafood.api.controller.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Problem {

    private LocalDateTime dataHora;
    private String message;

}
