package com.solenfrio.apicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solenfrio.apicore.model.EstacaoClimatica;

public interface EstacaoRepository extends JpaRepository<EstacaoClimatica, Long> {

}
