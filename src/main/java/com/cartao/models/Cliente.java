package com.cartao.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdCliente;

    @Size(min = 4, max = 100, message = "O nome deve ter no minimo 4 caracteres e no maximo 100")
    @NotNull
    private String nome;

    public Cliente() {
    }

    public Cliente(Integer idCliente, @Size(min = 4, max = 100, message = "O nome deve ter no minimo 4 caracteres e no maximo 100") @NotNull String nome) {
        IdCliente = idCliente;
        this.nome = nome;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer idCliente) {
        IdCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
