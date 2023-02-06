package com.algafood.domain.service;

import lombok.Builder;
import lombok.Data;

import java.io.InputStream;

public interface FotoStarageService {

    void armazenar(NovaFoto novaFoto);

    @Builder
    @Data
    class NovaFoto {
        private String nomeArquivo;
        private InputStream inputStream;
    }

}
