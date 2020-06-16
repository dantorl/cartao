package com.cartao.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagamento;

    @ManyToOne
    private Cartao cartao;
    //private Integer cartaoId;
    //Remover cartaoId e substituir por Cartao com anotação @ManyToOne
    //Criar DTO's e Mappers para requests e responses conforme contrato da API

    @NotNull
    @Size(min = 4, max = 20, message = "A descrição da compra deve ter no mínimo 4 caracteres")
    private String descricao;

    @NotNull
    private Double valor;

    public Pagamento() {
    }

    public Pagamento(Integer idPagamento, Cartao cartao, @NotNull @Size(min = 4, max = 20, message = "A descrição da compra deve ter no mínimo 4 caracteres") String descricao, @NotNull Double valor) {
        this.idPagamento = idPagamento;
        this.cartao = cartao;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
