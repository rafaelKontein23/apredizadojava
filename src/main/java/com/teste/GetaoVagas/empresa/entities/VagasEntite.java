package com.teste.GetaoVagas.empresa.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity (name = "Vagas")
public class VagasEntite {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private String benificios;
    private String level;

    @ManyToOne // Aqui é para falar que são várias vagas para uma empresa
    @JoinColumn(name = "empresa_id") // A chave primária da tabela empresa é usada como chave estrangeira nesta tabela
    private EmpresaEntity empresaEntity;

    @Column(name = "empresa_id", insertable = false, updatable = false) // Evita duplicação
    private UUID id_empresa; // Chave estrangeira

    @CreationTimestamp
    private LocalDateTime craeatAT;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBenificios() {
        return benificios;
    }

    public void setBenificios(String benificios) {
        this.benificios = benificios;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public EmpresaEntity getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public UUID getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(UUID id_empresa) {
        this.id_empresa = id_empresa;
    }

    public LocalDateTime getCraeatAT() {
        return craeatAT;
    }

    public void setCraeatAT(LocalDateTime craeatAT) {
        this.craeatAT = craeatAT;
    }
}
