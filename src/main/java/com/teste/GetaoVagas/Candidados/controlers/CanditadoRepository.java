package com.teste.GetaoVagas.Candidados.controlers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CanditadoRepository extends JpaRepository<CandidadosEntity, UUID> {

    Optional<CandidadosEntity> findByUserNameOrEmail(String userName, String email);
}
