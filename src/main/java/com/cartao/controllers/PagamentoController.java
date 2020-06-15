package com.cartao.controllers;

import com.cartao.models.Cartao;
import com.cartao.models.Pagamento;
import com.cartao.services.CartaoService;
import com.cartao.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarCartao(@RequestBody @Valid Pagamento pagamento) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorId(pagamento.getCartaoId());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
        Pagamento pagamentoObjeto = pagamentoService.cadastrarPagamento(pagamento);
        return ResponseEntity.status(201).body(pagamentoObjeto);
    }

    @GetMapping("/pagamentos/{id}")
    public Iterable<Pagamento> buscarPagamentos(@PathVariable Integer id) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorId(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
        return pagamentoService.buscarPagamentos(id);
    }
}
