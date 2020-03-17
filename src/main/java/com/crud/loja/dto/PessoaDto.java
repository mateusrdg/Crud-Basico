package com.crud.loja.dto;

import com.crud.loja.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto extends EntidadeId{

    @NotNull
    private String nome;

    public PessoaDto(Pessoa pessoa) {
        super(pessoa.getId());
        this.nome = pessoa.getNome();
    }
}
