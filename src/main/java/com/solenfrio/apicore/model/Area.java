package com.solenfrio.apicore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "area")
@Data
public class Area extends BaseEntity {

    @Column(name="descricao", length = 200, nullable = false)
    public String descricao;

    @Column(name="nome", length = 100, nullable = false)
    public String nome;
    
    @Column(name="area_hectares", nullable = false)
    public Double areaHectares;

    @JsonIgnore
    @OneToMany(mappedBy = "area")
    public List<EstacaoClimatica> estacoes;
}
