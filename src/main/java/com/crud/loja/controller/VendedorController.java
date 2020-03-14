package com.crud.loja.controller;

import com.crud.loja.domain.Vendedor;
import com.crud.loja.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    VendedorService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Vendedor> find(@PathVariable Long id) {
        Vendedor vendedor = service.find(id);
        return ResponseEntity.ok(vendedor);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Vendedor vendedor) {
        service.insert(vendedor);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@PathVariable Long id, @RequestBody Vendedor vendedor){
        service.update(id, vendedor);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Vendedor>> findAll(){
        List<Vendedor> vendedores = service.findAll();
        return ResponseEntity.ok(vendedores);
    }
}
