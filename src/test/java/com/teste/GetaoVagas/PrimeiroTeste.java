package com.teste.GetaoVagas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PrimeiroTeste {

    @Test // pra indicar que é um teste, com essa anotação vc vai conseguir rodar essse teste
    public void deve_ser_possivel_calcular_dois_numeros(){
        var resultado = calcula(2,3); // funcao
        assertEquals(resultado, 4); // aqui você tem que falar o resultado que vai vim da funcao e no caso o "5" é resultado esperado, ai ele fala se deu certo
    }

    @Test
    public void  validar_valor_incorreto(){
        var result = calcula(2, 3);
        assertNotEquals(result,4); // aqui é pra quanbo vc nao quer que o resultado seja esse
    }

    public static int calcula(int num1, int num2){ // funcao
        return num1 + num2;
    }
}

