package com.cartao.controllers;

import com.cartao.models.Usuario;
import com.cartao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/useradmin")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody @Valid Usuario usuario){
        Usuario userobj;

        try{
            userobj = usuarioService.salvarUsuario(usuario);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }

        return  ResponseEntity.status(201).body(userobj);
    }
}

