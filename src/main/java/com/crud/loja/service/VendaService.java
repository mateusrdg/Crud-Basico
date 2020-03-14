package com.crud.loja.service;

import com.crud.loja.domain.Venda;
import com.crud.loja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VendaService {

    @Autowired
    VendaRepository repository;

    public Venda find(Long id){
        Optional<Venda> consulta = repository.findById(id);
        Venda venda = consulta.orElseThrow( ()-> new RuntimeException("Venda não encontrado"));
        return venda;
    }

    public void insert (Venda venda) {
        venda.setId(null);
        repository.save(venda);
    }
    public void update(Long id, Venda venda){
        venda.setId(id);
        repository.save(venda);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


    public List<Venda> findAll() {
        return repository.findAll();
    }
}
