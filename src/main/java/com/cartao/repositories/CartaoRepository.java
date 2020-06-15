package com.cartao.repositories;

import com.cartao.models.Cartao;
import com.cartao.models.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {

    Optional<Cartao> findByNumero(String numero);
}
