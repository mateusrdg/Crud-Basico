package com.crud.loja.controller;

import com.crud.loja.dto.PessoaDto;
import com.crud.loja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<PessoaDto> find(@PathVariable Long id) {
        PessoaDto cliente = service.find(id);
        return ResponseEntity.ok(cliente);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaDto cliente) {
        service.insert(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@PathVariable Long id, @Valid @RequestBody PessoaDto cliente){
        service.update(id, cliente);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDto>> findAll(){
        List<PessoaDto> clientes = service.findAll();
        return ResponseEntity.ok(clientes);
    }
}
