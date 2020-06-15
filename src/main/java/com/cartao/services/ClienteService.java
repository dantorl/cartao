package com.cartao.services;


import com.cartao.models.Cartao;
import com.cartao.models.Cliente;
import com.cartao.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        Cliente clienteObjeto = clienteRepository.save(cliente);
        return clienteObjeto;
    }

    public Iterable<Cliente> buscarTodosClientes() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Optional<Cliente> buscarClientePorId(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return clienteOptional;
        } else {
            throw new ObjectNotFoundException("","Nao localizado Cliente com o Código informado");
        }
    }

}
