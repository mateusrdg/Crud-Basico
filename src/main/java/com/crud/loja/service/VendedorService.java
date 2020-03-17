package com.crud.loja.service;

import com.crud.loja.domain.Vendedor;
import com.crud.loja.dto.PessoaDto;
import com.crud.loja.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VendedorService {

    @Autowired
    VendedorRepository repository;

    public PessoaDto find(Long id){
        Optional<Vendedor> optionalVendedor = repository.findById(id);
        Vendedor vendedor = optionalVendedor.orElseThrow( ()-> new RuntimeException("Vendedor não encontrado"));
        return new PessoaDto(vendedor);
    }

    public Vendedor insert (PessoaDto objDto) {
        objDto.setId(null);
        Vendedor vendedor = fromDto(objDto);
        repository.save(vendedor);
        return vendedor;
    }

    public void update(Long id, PessoaDto objDto){
        objDto.setId(id);
        Vendedor vendedor = fromDto(objDto);
        repository.save(vendedor);
    }

    public Vendedor fromDto(PessoaDto objDto) {
        return new Vendedor(objDto.getId(),objDto.getNome());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<PessoaDto> findAll() {
        return repository.findAll().stream().map(PessoaDto::new).collect(Collectors.toList());
    }
}
