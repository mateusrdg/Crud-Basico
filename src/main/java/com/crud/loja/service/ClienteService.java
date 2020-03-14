package com.crud.loja.service;

import com.crud.loja.domain.Cliente;
import com.crud.loja.repository.ClienteRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente find(Long id){
        Optional<Cliente> consulta = repository.findById(id);
        Cliente cliente = consulta.orElseThrow( ()-> new RuntimeException("Cliente não encontrado"));
        return cliente;
    }

    public void insert (Cliente cliente) {
        cliente.setId(null);
        repository.save(cliente);
    }
    public void update(Long id, Cliente cliente){
        cliente.setId(id);
        repository.save(cliente);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


    public List<Cliente> findAll() {
        return repository.findAll();
    }
}
