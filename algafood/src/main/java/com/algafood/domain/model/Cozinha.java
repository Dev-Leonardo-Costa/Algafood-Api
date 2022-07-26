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
    private Long id;

  
    @Column(nullable = false)
    private String nome;
}




