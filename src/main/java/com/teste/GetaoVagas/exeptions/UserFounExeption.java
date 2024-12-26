package com.teste.GetaoVagas.exeptions;

public class UserFounExeption  extends RuntimeException{
    public UserFounExeption(){
        super("Empresa ja existe");
    }

}
