package com.crud.loja.service;

import com.crud.loja.domain.Vendedor;
import com.crud.loja.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VendedorService {

    @Autowired
    VendedorRepository repository;

    public Vendedor find(Long id){
        Optional<Vendedor> consulta = repository.findById(id);
        Vendedor vendedor = consulta.orElseThrow( ()-> new RuntimeException("Vendedor não encontrado"));
        return vendedor;
    }

    public void insert (Vendedor vendedor) {
        vendedor.setId(null);
        repository.save(vendedor);
    }
    public void update(Long id, Vendedor vendedor){
        vendedor.setId(id);
        repository.save(vendedor);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


    public List<Vendedor> findAll() {
        return repository.findAll();
    }
}
