package io.github.filiperodrigues.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {

    @Getter //para o spring transformar o objeto api erros em json
    private List<String> erros;

    //construtor com parametros
    public ApiErros(List<String> erros){
        this.erros = erros;

    }
    //construtor com uma unica menssagem
    public ApiErros(String message){
        this.erros = Arrays.asList(message); // transofrmando um objeto em lista
    }
}
