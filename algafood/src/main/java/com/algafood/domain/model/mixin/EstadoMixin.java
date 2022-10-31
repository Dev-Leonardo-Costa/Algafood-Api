package com.algafood.domain.model.mixin;

import com.algafood.domain.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public abstract class EstadoMixin {

    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Estado estado;

}
