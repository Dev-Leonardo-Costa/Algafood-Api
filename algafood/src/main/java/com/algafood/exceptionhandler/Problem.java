package com.algafood.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Problem {

    private LocalDateTime tamestamp;
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<Field> fields;

    @Getter
    @Builder
    public static class Field {
       private String name;
        private String userMessage;
    }

}
