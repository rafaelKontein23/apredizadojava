package com.teste.GetaoVagas.Candidados.controlers;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.UUID;
@Entity(name = "candidados") // nome da tabaela
public class CandidadosEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID) // para criar o id automaticamente
    private UUID id;

    @Column(name = "name") // aqui seria o nome da coluna, mas isso so se vc quiser que o nome do objeto seja diferente do nome do objeto
    private String nome;
    @Pattern(regexp =  "^(?!!\\s*).+" , message =  "nao pode ter espaço")
    private String userName;
    @Email(message = "Email inválido")
    private String email;

    @Length(min= 1)
    private String senha;
    private String descricao;
    private String curriculo;

    @CreationTimestamp
    private LocalDate createAt; // seria o o dia que foi criado a tabela


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }


}
