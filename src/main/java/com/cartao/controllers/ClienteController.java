package com.cartao.controllers;

import com.cartao.models.Cliente;
import com.cartao.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid Cliente cliente) {

        Cliente investimentoObjeto = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(201).body(investimentoObjeto);
    }

    @GetMapping
    public Iterable<Cliente> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional;
        try{
            clienteOptional = clienteService.buscarClientePorId(id);
            return clienteOptional.get();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }
}
