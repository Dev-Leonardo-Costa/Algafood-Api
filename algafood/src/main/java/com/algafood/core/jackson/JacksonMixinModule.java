package com.algafood.core.jackson;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Estado;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.model.mixin.CozinhaMixin;
import com.algafood.domain.model.mixin.EstadoMixin;
import com.algafood.domain.model.mixin.RestauranteMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
        setMixInAnnotation(Estado.class, EstadoMixin.class);
    }

}
