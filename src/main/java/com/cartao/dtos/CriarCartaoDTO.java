package com.cartao.dtos;

public class CriarCartaoDTO {

    private String numero;

    private Integer clienteId;

    public CriarCartaoDTO() {
    }

    public CriarCartaoDTO(String numero, Integer clienteId) {
        this.numero = numero;
        this.clienteId = clienteId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
