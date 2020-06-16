package com.cartao.mappers;

import com.cartao.dtos.PagamentoRequestDTO;
import com.cartao.dtos.PagamentoResponseDTO;
import com.cartao.models.Cartao;
import com.cartao.models.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoMapper {

    public static PagamentoResponseDTO toPagamentoResponse(Pagamento pagamento) {
        PagamentoResponseDTO pagamentoResponse = new PagamentoResponseDTO();

        pagamentoResponse.setId(pagamento.getIdPagamento());
        pagamentoResponse.setIdCartao(pagamento.getCartao().getIdCartao());
        pagamentoResponse.setDescricao(pagamento.getDescricao());
        pagamentoResponse.setValor(pagamento.getValor());

        return pagamentoResponse;
    }

    public static List<PagamentoResponseDTO> toPagamentoResponse(List<Pagamento> pagamentos) {
        List<PagamentoResponseDTO> pagamentoResponses = new ArrayList<>();

        for (Pagamento pagamento : pagamentos) {
            pagamentoResponses.add(toPagamentoResponse(pagamento));
        }

        return pagamentoResponses;
    }

    public static Pagamento toPagamento(PagamentoRequestDTO createPagamentoRequest) {
        Cartao cartao = new Cartao();
        cartao.setIdCartao(createPagamentoRequest.getIdCartao());

        Pagamento pagamento = new Pagamento();

        pagamento.setDescricao(createPagamentoRequest.getDescricao());
        pagamento.setValor(createPagamentoRequest.getValor());
        pagamento.setCartao(cartao);

        return pagamento;
    }

}
