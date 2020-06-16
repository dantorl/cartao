package com.cartao.controllers;

import com.cartao.dtos.CriarCartaoDTO;
import com.cartao.models.Cartao;
import com.cartao.models.Cliente;
import com.cartao.services.CartaoService;
import com.cartao.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cartao> cadastrarCartao(@RequestBody @Valid Cartao cartao) {
        Optional<Cliente> clienteOptional;
        try{
            clienteOptional = clienteService.buscarClientePorId(cartao.getClienteId());
         } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
        cartao.setAtivo(false);

        try{
            Cartao cartaoObjeto = cartaoService.cadastrarCartao(cartao);
            return ResponseEntity.status(201).body(cartaoObjeto);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @PostMapping("/teste")
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao createCartao(@RequestBody CriarCartaoDTO criarCartaoDTO) {
        Optional<Cliente> clienteOptional;
        try{
            clienteOptional = clienteService.buscarClientePorId(criarCartaoDTO.getClienteId());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }

        Cartao cartaoObjeto = new Cartao();
        cartaoObjeto.setNumero(criarCartaoDTO.getNumero());
        cartaoObjeto.setAtivo(false);
        cartaoObjeto.setClienteId(criarCartaoDTO.getClienteId());

        return cartaoService.createCartao(cartaoObjeto);

    }

    @PatchMapping("/{numero}")
    public Cartao ativarCartao(@PathVariable String numero) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorNumero(numero);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }

        Cartao cartao = cartaoOptional.get();

        Cartao cartaoObjeto = cartaoService.ativarCartao(cartao);
        return cartaoObjeto;
    }

    @GetMapping("/{numero}")
    public Cartao buscarCartaoPorNumero(@PathVariable String numero) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorNumero(numero);
            return cartaoOptional.get();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }
    @GetMapping
    public Iterable<Cartao> buscarTodosCartoes() {
        return cartaoService.buscarTodosCartoes();
    }
}
