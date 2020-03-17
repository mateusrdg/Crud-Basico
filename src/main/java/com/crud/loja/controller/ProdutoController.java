package com.crud.loja.controller;

import com.crud.loja.domain.Produto;
import com.crud.loja.dto.ProdutoDto;
import com.crud.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<ProdutoDto> find(@PathVariable Long id) {
        ProdutoDto produto = service.find(id);
        return ResponseEntity.ok(produto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody @Valid ProdutoDto dto) {
        Produto produto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@PathVariable Long id, @Valid @RequestBody ProdutoDto dto){
        service.update(id, dto);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProdutoDto>> findAll(){
        List<ProdutoDto> produtosResponse = service.findAll();
        return ResponseEntity.ok(produtosResponse);
    }
}
