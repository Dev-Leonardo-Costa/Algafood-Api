package com.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

//		CriteriaBuilder builder = manager.getCriteriaBuilder();
		var builder = manager.getCriteriaBuilder();
		
//		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
//		Root<Restaurante> root = criteria.from(Restaurante.class);
		var criteria = builder.createQuery(Restaurante.class);
		var root = criteria.from(Restaurante.class);
		
		var predicates = new ArrayList<Predicate>();

		if (StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		
		if (taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}

		if (taxaFreteFinal != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}

		criteria.where(predicates.toArray(new Predicate[0]));

//		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		var query = manager.createQuery(criteria);
		return query.getResultList();
//		return manager.createQuery(criteria).getResultList();

	}
}

// consulta do metodo find
//var jpql = new StringBuilder();
//jpql.append("from Restaurante where 0 = 0 ");
//
//var parametros = new HashMap<String, Object>();
//
//if (StringUtils.hasLength(nome)) {
//	jpql.append("and nome like :nome ");
//	parametros.put("nome", "%" + nome + "%");
//}
//
//if (taxaFreteInicial != null) {
//	jpql.append("and taxaFrete >= :taxaInicial ");
//	parametros.put("taxaInicial", taxaFreteInicial);
//}
//
//if (taxaFreteFinal != null) {
//	jpql.append("and taxaFrete <= :taxaFinal ");
//	parametros.put("taxaFinal", taxaFreteFinal);
//}
//
//TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
//
//parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
//
//return query.getResultList();