package io.github.filiperodrigues.controller;

import io.github.filiperodrigues.controller.exeption.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice

@ControllerAdvice
public class ApplicationControllerAdvice {

    //capturar a exption pegar o binding resalt que tem todas as mensagens de erro e retornar como objeto padronizado
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidationErros(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErros(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException exception){
        String menssagemErro = exception.getMessage();
        HttpStatus codigoStatus = exception.getStatus();
        ApiErros apiErros = new ApiErros(menssagemErro);
        return new ResponseEntity(apiErros,codigoStatus);
    }
}
