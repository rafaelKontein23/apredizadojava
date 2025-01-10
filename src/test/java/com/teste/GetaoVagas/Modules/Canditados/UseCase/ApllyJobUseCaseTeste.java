package com.teste.GetaoVagas.Modules.Canditados.UseCase;

import com.teste.GetaoVagas.Candidados.Entity.AplyJobEntity;
import com.teste.GetaoVagas.Candidados.Repository.ApplyJobRepository;
import com.teste.GetaoVagas.Candidados.UseCase.ApllyJobUseCase;
import com.teste.GetaoVagas.Candidados.controlers.CandidadosEntity;
import com.teste.GetaoVagas.Candidados.controlers.CanditadoRepository;
import com.teste.GetaoVagas.empresa.entities.VagasEntite;
import com.teste.GetaoVagas.empresa.reposytory.VagasRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // pra ele mokar as informações da class
public class ApllyJobUseCaseTeste {

    @InjectMocks // pra instaciar a class
    private ApllyJobUseCase apllyJobUseCase;

    @Mock // aqui é para instaciar as depencias que a class que vc esta usando precisa , se vc entrar no metodo execute vai vai que tem as mesma class
    private CanditadoRepository canditadoRepository;

    @Mock
    private VagasRepository vagasRepository ;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Não pode se aplicar a uma vaga se o canditado não existir")
    public void ver_se_tem_caditado_na_base_antes_de_aplicar(){
        try {
            apllyJobUseCase.execute(null,null);
        }catch (Exception e){
            assertThat(e).isInstanceOf(UserFounExeption.class); // pra verificar do erro é do tipo correto

        }
    }

    @Test
    @DisplayName("\"Não pode se aplicar a uma vaga se o vaga não existir")
    public void ver_se_tem_vaga_na_base_antes_de_aplicar(){
        var idCanditado = UUID.randomUUID();
        var cantidate = new CandidadosEntity();
        cantidate.setId(idCanditado);
        when(canditadoRepository.findById(idCanditado)).thenReturn(Optional.of(cantidate)); // essa parte toda acima estamos mocando,
        try {
            apllyJobUseCase.execute(idCanditado,null);

        }catch (Exception e){
            assertThat(e).isInstanceOf(UserFounExeption.class);

        }

    }

    @Test
    @DisplayName("testa caso tudo ter correto")
    public void  quando_consegue_aplicar_para_uma_vaga(){

        var idCanditado = UUID.randomUUID();
        var idVaga = UUID.randomUUID();

        var aplyJobEntity = new AplyJobEntity(idCanditado,idVaga);
        aplyJobEntity.setId(UUID.randomUUID());
        when(applyJobRepository.save(aplyJobEntity)).thenReturn(aplyJobEntity);
        var  result = apllyJobUseCase.execute(idCanditado, idVaga);
        assertThat(result ).isInstanceOf(AplyJobEntity.class);
    }
}
