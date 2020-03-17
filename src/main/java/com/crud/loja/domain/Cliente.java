package com.crud.loja.domain;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor

public class Cliente extends Pessoa {
    public Cliente(String nome) {
        super(nome);
    }

    public Cliente(Long id, String nome) {
        super(id, nome);
    }
}
