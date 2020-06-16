package com.cartao.services;

import com.cartao.exceptions.CartaoAlreadyExistsException;
import com.cartao.models.Cartao;
import com.cartao.models.Cliente;
import com.cartao.repositories.CartaoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao cadastrarCartao(Cartao cartao) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumero(cartao.getNumero());
        if (cartaoOptional.isPresent()) {
            throw new ObjectNotFoundException("","Número de Cartão já existe");
        } else {

            Cartao cartaoObjeto = cartaoRepository.save(cartao);
            return cartaoObjeto;
        }
    }

    public Cartao createCartao(Cartao cartao) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumero(cartao.getNumero());
        if (cartaoOptional.isPresent()) {
            throw new CartaoAlreadyExistsException();
        } else {

            Cartao cartaoObjeto = cartaoRepository.save(cartao);
            return cartaoObjeto;
        }
    }

    public Optional<Cartao> buscarCartaoPorNumero(String numero) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumero(numero);
        if (cartaoOptional.isPresent()) {
            return cartaoOptional;
        } else {
            throw new ObjectNotFoundException("","Nao localizado Cartão com o Número informado");
        }
    }

    public Optional<Cartao> buscarCartaoPorId(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        if (cartaoOptional.isPresent()) {
            return cartaoOptional;
        } else {
            throw new ObjectNotFoundException("","Nao localizado Cartão com o Número informado");
        }
    }

    public Cartao ativarCartao(Cartao cartao) {
        cartao.setAtivo(true);
        Cartao cartaoObjeto = cartaoRepository.save(cartao);
        return cartaoObjeto;
    }

    public Iterable<Cartao> buscarTodosCartoes() {
        Iterable<Cartao> cartoes = cartaoRepository.findAll();
        return cartoes;
    }
}
