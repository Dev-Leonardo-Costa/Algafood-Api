package com.algafood.domain.model;

import com.algafood.Grups;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Cidade {

    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Não pode ser nulo nem branco")
    @Column(nullable = false)
    private String nome;

    @Valid
    @ConvertGroup(from = Default.class, to = Grups.EstadoId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
}
