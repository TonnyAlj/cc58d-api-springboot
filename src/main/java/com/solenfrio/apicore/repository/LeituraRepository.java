package com.solenfrio.apicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solenfrio.apicore.model.LeituraClimatica;

public interface LeituraRepository extends JpaRepository<LeituraClimatica, Long> {

}
