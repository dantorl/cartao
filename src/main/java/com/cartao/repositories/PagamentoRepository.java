package com.cartao.repositories;

import com.cartao.models.Pagamento;
import org.springframework.data.repository.CrudRepository;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {

    Iterable<Pagamento> findByCartaoId(Integer cartaoId);
}
