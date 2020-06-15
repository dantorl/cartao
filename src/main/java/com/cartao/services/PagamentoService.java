package com.cartao.services;

import com.cartao.models.Cartao;
import com.cartao.models.Pagamento;
import com.cartao.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        Pagamento pagamentoObjeto = pagamentoRepository.save(pagamento);
        return pagamentoObjeto;
    }

    public Iterable<Pagamento> buscarPagamentos(Integer id) {
        Iterable<Pagamento> pagamentos = pagamentoRepository.findByCartaoId(id);
        return pagamentos;
    }

}
