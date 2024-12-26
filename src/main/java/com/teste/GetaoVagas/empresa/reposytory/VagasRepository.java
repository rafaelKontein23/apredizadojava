package com.teste.GetaoVagas.empresa.reposytory;

import com.teste.GetaoVagas.empresa.entities.VagasEntite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VagasRepository extends JpaRepository<VagasEntite, UUID> {
}
