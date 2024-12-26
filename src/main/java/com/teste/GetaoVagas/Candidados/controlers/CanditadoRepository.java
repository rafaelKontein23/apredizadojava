package com.teste.GetaoVagas.Candidados.controlers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CanditadoRepository extends JpaRepository<CandidadosEntity, UUID> {


}
