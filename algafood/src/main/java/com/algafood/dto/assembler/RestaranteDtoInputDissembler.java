package com.algafood.dto.assembler;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.dto.input.RestauranteInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaranteDtoInputDissembler {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurante toDoMainObject(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    public void copyToDomainObjetct(RestauranteInput restauranteInput, Restaurante restaurante) {
        // Para Evitar essa exception (org.springframework.orm.jpa.JpaSystemException: identifier of an instance of
        // com.algafood.domain.model.Cozinha was altered from 1 to 2; nested exception is org.hibernate.HibernateException: identifier of an instance of com.algafood.domain.model.Cozinha was altered from 1 to 2)
        restaurante.setCozinha(new Cozinha());
        modelMapper.map(restauranteInput, restaurante);
    }
}