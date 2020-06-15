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

    @NotNull
    private Integer cartaoId;

    @NotNull
    @Size(min = 4, max = 20, message = "A descrição da compra deve ter no mínimo 4 caracteres")
    private String descricao;

    @NotNull
    private Double valor;

    public Pagamento() {
    }

    public Pagamento(Integer idPagamento, @NotNull Integer cartaoId, @NotNull @Size(min = 4, max = 20, message = "A descrição da compra deve ter no mínimo 4 caracteres") String descricao, @NotNull Double valor) {
        this.idPagamento = idPagamento;
        this.cartaoId = cartaoId;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Integer cartaoId) {
        this.cartaoId = cartaoId;
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
