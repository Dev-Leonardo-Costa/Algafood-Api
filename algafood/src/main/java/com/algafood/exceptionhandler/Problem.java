package com.algafood.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Problem {

    private LocalDateTime tamestamp;
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;

}
