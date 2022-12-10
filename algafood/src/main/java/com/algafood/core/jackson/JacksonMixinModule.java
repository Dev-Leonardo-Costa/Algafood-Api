package com.algafood.core.jackson;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Estado;
import com.algafood.domain.model.mixin.CozinhaMixin;
import com.algafood.domain.model.mixin.EstadoMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
        setMixInAnnotation(Estado.class, EstadoMixin.class);
    }

}
