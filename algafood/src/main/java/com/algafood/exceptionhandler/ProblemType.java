package com.algafood.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    ERRO_NEGOCIO("/erro-negócio", "Violação de regra de negócio"),
    ENTIDADE_EM_USO("/entidade-em-uso","Entidade em uso"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel","Mensagem incompreensível");


    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://algafood.com.br" + path;
        this.title = title;
    }

}
