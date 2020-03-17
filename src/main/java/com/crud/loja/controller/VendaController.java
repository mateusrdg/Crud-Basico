package com.crud.loja.controller;

import com.crud.loja.domain.Venda;
import com.crud.loja.dto.VendaDto;
import com.crud.loja.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    VendaService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<VendaDto> find(@PathVariable Long id) {
        VendaDto venda = service.find(id);
        return ResponseEntity.ok(venda);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody VendaDto venda) {
        service.insert(venda);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@PathVariable Long id,@Valid @RequestBody VendaDto venda){
        service.update(id, venda);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VendaDto>> findAll(){
        List<VendaDto> vendas = service.findAll();
        return ResponseEntity.ok(vendas);
    }
}
