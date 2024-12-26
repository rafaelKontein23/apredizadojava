package com.teste.GetaoVagas.empresa.reposytory;

import com.teste.GetaoVagas.empresa.entities.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, UUID> {

    Optional<EmpresaEntity> findByUserNameOrEmail(String useerName, String email); // aqui serve para procura a empresa por email ou userName, se tiver ele não deixa registrae
}
