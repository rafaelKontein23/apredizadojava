package com.teste.GetaoVagas.Candidados.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacaoCantidadoDto {

    private String userName;
    private String senha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public AutenticacaoCantidadoDto(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }


}
