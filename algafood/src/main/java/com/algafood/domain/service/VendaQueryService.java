package com.algafood.domain.service;

import com.algafood.dto.VendaDiaria;
import com.algafood.filter.VendaDiariaFilter;

import java.util.List;

public interface VendaQueryService {

    List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffSet);

}
