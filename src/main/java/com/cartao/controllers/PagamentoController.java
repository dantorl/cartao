package com.cartao.controllers;

import com.cartao.dtos.PagamentoRequestDTO;
import com.cartao.dtos.PagamentoResponseDTO;
import com.cartao.mappers.PagamentoMapper;
import com.cartao.models.Cartao;
import com.cartao.models.Pagamento;
import com.cartao.services.CartaoService;
import com.cartao.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PagamentoController {
    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagamento")
    public PagamentoResponseDTO cadastrarCartao(@RequestBody PagamentoRequestDTO pagamentoRequest) {
        Pagamento pagamento = PagamentoMapper.toPagamento(pagamentoRequest);
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorId(pagamento.getCartao().getIdCartao());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
        pagamento.setCartao(cartaoOptional.get());
        Pagamento pagamentoObjeto = pagamentoService.cadastrarPagamento(pagamento);
        return PagamentoMapper.toPagamentoResponse(pagamentoObjeto);
    }

    @GetMapping("/pagamentos/{id}")
    public List<PagamentoResponseDTO> buscarPagamentos(@PathVariable Integer id) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorId(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
        List<Pagamento> pagamentos = pagamentoService.buscarPagamentos(id);
        return PagamentoMapper.toPagamentoResponse(pagamentos);
    }
}
