package com.teste.GetaoVagas.exeptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExeptionHadler {
     private MessageSource  messageSource;

     public ExeptionHadler(MessageSource messageSource){
         this.messageSource = messageSource;
     }

    @ExceptionHandler(MethodArgumentNotValidException.class) // pra especificar que o ero é dessa class , com iiso o spring entente que é pra cair aqui caso ter erro
    public ResponseEntity<List<ErrorMessageDTO>> handleNotArgument(MethodArgumentNotValidException e){
        List<ErrorMessageDTO> dtoList = new  ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(err ->{ // aqui vc está pegando todos os erros
            String  message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDTO dto = new ErrorMessageDTO(message, err.getField());
            dtoList.add(dto);
            System.out.println(message);

        });
        return new ResponseEntity<>(dtoList, HttpStatus.BAD_REQUEST); // aqui vai ser o retorno do erro tratado

    }
}
