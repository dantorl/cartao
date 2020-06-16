package com.cartao.services;

import com.cartao.models.Cartao;
import com.cartao.models.Pagamento;
import com.cartao.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        Pagamento pagamentoObjeto = pagamentoRepository.save(pagamento);
        return pagamentoObjeto;
    }

    public List<Pagamento> buscarPagamentos(Integer id) {
        List<Pagamento> pagamentos = pagamentoRepository.findByCartao_IdCartao(id);
        return pagamentos;
    }

}
