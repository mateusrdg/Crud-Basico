package com.crud.loja.domain;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
public class Vendedor extends Pessoa {

    public Vendedor(String nome) {
        super(nome);
    }

    public Vendedor(Long id, String nome) {
        super(id, nome);
    }

}
