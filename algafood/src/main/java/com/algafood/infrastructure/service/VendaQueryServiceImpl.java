package com.algafood.infrastructure.service;

import com.algafood.domain.model.Pedido;
import com.algafood.domain.model.enums.StatusPedido;
import com.algafood.domain.service.VendaQueryService;
import com.algafood.dto.VendaDiariaDTO;
import com.algafood.filter.VendaDiariaFilter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class VendaQueryServiceImpl implements VendaQueryService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<VendaDiariaDTO> consultarVendasDiarias(VendaDiariaFilter filtro) {
        var builder = manager.getCriteriaBuilder();
        var query = builder.createQuery(VendaDiariaDTO.class);
        var root = query.from(Pedido.class);
        var predicates = new ArrayList<Predicate>();

        var functionDateDataCriacao = builder.function(
                "date", Date.class, root.get("dataCriacao"));

        var selection = builder.construct(VendaDiariaDTO.class,
                functionDateDataCriacao,
                builder.count(root.get("id")),
                builder.sum(root.get("valorTotal")));

        if (filtro.getRestauranteId() != null){
            predicates.add((Predicate) builder.equal(root.get("restaurante"), filtro.getRestauranteId()));
        } if (filtro.getDataCriacaoInicio() != null){
            predicates.add((Predicate) builder.equal(root.get("dataCriacao"), filtro.getDataCriacaoInicio()));
        } if (filtro.getGetDataCriacaoFim() != null){
            predicates.add((Predicate) builder.equal(root.get("dataCriacao"), filtro.getGetDataCriacaoFim()));
        }
        predicates.add((Predicate) root.get("status").in(StatusPedido.CONFIRMADO, StatusPedido.ENTREGUE));

        query.select(selection);
        query.where(predicates.toArray(new Predicate[0]));
        query.groupBy(functionDateDataCriacao);
        return  manager.createQuery(query).getResultList();
    }

}
