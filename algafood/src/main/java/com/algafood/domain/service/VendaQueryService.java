package com.algafood.domain.service;

import com.algafood.dto.VendaDiariaDTO;
import com.algafood.filter.VendaDiariaFilter;

import java.util.List;

public interface VendaQueryService {

    List<VendaDiariaDTO> consultarVendasDiarias(VendaDiariaFilter filtro);

}
