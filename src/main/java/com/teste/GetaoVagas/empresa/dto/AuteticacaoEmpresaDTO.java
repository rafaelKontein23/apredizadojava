package com.teste.GetaoVagas.empresa.dto;

public class AuteticacaoEmpresaDTO {
    private String userName;
    private String senha;
    public AuteticacaoEmpresaDTO(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
