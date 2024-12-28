package com.teste.GetaoVagas.Candidados.Dto;



public class AuthCandidateResponseSTO {
    private String access_token;
    private String duracao;

    public AuthCandidateResponseSTO() {
    }

    public AuthCandidateResponseSTO(String access_token, String duracao) {
        this.access_token = access_token;
        this.duracao = duracao;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
