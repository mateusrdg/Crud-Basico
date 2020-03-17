package com.crud.loja.service;

import com.crud.loja.domain.Produto;
import com.crud.loja.dto.ProdutoDto;
import com.crud.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public ProdutoDto find(Long id){
        Optional<Produto> consulta = repository.findById(id);
        Produto produto = consulta.orElseThrow( ()-> new RuntimeException("Produto não encontrado"));
        return new ProdutoDto(produto);
    }

    public Produto insert (ProdutoDto objDto) {
        objDto.setId(null);
        Produto produto = fromDto(objDto);
        repository.save(produto);
        return produto;
    }

    public Produto update(Long id, ProdutoDto objDto){
        objDto.setId(id);
        Produto produto = fromDto(objDto);
        repository.save(produto);
        return produto;
    }

    public Produto fromDto(ProdutoDto objDto) {
        return new Produto((objDto.getId()), objDto.getDescricao(), objDto.getValor());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<ProdutoDto> findAll() {
        return repository.findAll().stream().map(ProdutoDto::new).collect(Collectors.toList());
    }
}
