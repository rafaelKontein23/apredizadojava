package com.teste.GetaoVagas.Candidados.Entity;


import com.teste.GetaoVagas.Candidados.controlers.CandidadosEntity;
import com.teste.GetaoVagas.empresa.entities.VagasEntite;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "apply_jobs")
public class AplyJobEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "candidado_id", insertable = false, updatable = false)
    private CandidadosEntity candidadosEntity;

    @ManyToOne
    @JoinColumn(name = "vaga_id", insertable = false, updatable = false)//  Evita duplicação
    private VagasEntite vagasEntite;

    @Column(name = "candidado_id")
    private UUID candidadoId;

    @Column(name = "vaga_id")
    private UUID vagaId;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    public AplyJobEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AplyJobEntity(UUID vagaId, UUID candidadoId) {
        this.vagaId = vagaId;
        this.candidadoId = candidadoId;
    }
}
