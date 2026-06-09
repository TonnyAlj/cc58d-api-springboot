package com.solenfrio.apicore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "estacao_climatica")
@Data
public class EstacaoClimatica extends BaseEntity {
     
    @Column(name="nome", length = 100, nullable = false)
    public String nome;

    @Column(name="cidade", length = 100, nullable = false)
    public String cidade;

    @Column(name="latitude", nullable = false)
    public Double latitude;

    @Column(name="longitude", nullable = false)
    public Double longitude;

    @ManyToOne
    @JoinColumn(name = "area_id")
    public Area area;

    @OneToMany(mappedBy = "estacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<LeituraClimatica> leituras;

    @OneToMany(mappedBy = "estacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<AlertaClima> alertas;
}
