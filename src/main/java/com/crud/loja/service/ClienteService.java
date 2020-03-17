package com.crud.loja.service;

import com.crud.loja.domain.Cliente;
import com.crud.loja.dto.PessoaDto;
import com.crud.loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public PessoaDto find(Long id){
        Optional<Cliente> optionalCliente = repository.findById(id);
        Cliente cliente = optionalCliente.orElseThrow( ()-> new RuntimeException("Cliente não encontrado"));
        return new PessoaDto(cliente);
    }

    public Cliente insert (PessoaDto objDto) {
        objDto.setId(null);
        Cliente cliente = fromDto(objDto);
        repository.save(cliente);
        return cliente;
    }

    public Cliente update(Long id, PessoaDto objDto){
        objDto.setId(id);
        Cliente cliente = fromDto(objDto);
        repository.save(cliente);
        return cliente;
    }

    public Cliente fromDto(PessoaDto objDto) {
        return new Cliente(objDto.getId(), objDto.getNome());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<PessoaDto> findAll() {
        return repository.findAll().stream().map(PessoaDto::new).collect(Collectors.toList());
    }
}
