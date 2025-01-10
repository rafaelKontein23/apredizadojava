package com.teste.GetaoVagas.Candidados.Repository;

import com.teste.GetaoVagas.Candidados.Entity.AplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<AplyJobEntity, UUID> {


}
