package com.teste.GetaoVagas.Candidados.Dto;

public class CadidadoProfileResponseDTo {

    private String descricao;
    private String userName;
    private String nome;

    public CadidadoProfileResponseDTo() {
    }

    public CadidadoProfileResponseDTo(String descricao, String userName, String nome) {
        this.descricao = descricao;
        this.userName = userName;
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
