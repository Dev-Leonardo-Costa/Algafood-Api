package com.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;


@JsonRootName("cozinha")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Cozinha {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;
   
//  Só e usado quando é priciso de uma regra de negocio especifica     
//    @JsonIgnore
//    @OneToMany(mappedBy = "cozinha")
//    private List<Restaurante> restaurantes = new ArrayList<>();
    
    
}





