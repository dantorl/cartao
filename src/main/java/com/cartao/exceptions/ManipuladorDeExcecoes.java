package com.cartao.exceptions;

import com.cartao.errors.ObjetoDeErro;
import com.cartao.errors.RespostaDeErro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ObjetoDeErro> objetoDeErros = getErros(ex);
        RespostaDeErro respostaDeErro = getRespostaDeErro(ex, status, objetoDeErros);
        return ResponseEntity.status(status).body(respostaDeErro);
    }

    private RespostaDeErro getRespostaDeErro(MethodArgumentNotValidException notValid, HttpStatus status, List<ObjetoDeErro> objetoDeErros){
        RespostaDeErro respostaDeErro = new RespostaDeErro("Erro de Validação", status.value(), status.getReasonPhrase(),
                notValid.getBindingResult().getObjectName(), objetoDeErros);
        return respostaDeErro;

    }

    private List<ObjetoDeErro> getErros(MethodArgumentNotValidException exception){
        List<ObjetoDeErro> objetoDeErros = exception.getBindingResult().getFieldErrors()
                .stream().map(erro -> new ObjetoDeErro(erro.getDefaultMessage(), erro.getField(),
                        erro.getRejectedValue())).collect(Collectors.toList());
        return objetoDeErros;
    }
}
