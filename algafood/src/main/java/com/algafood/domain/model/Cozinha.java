package com.algafood.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


@JsonRootName("cozinha")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Cozinha {

    @NotNull
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