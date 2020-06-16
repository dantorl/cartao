package com.cartao.repositories;

import com.cartao.models.Pagamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {

    List<Pagamento> findByCartao_IdCartao(Integer Cartao_IdCartao);
}
