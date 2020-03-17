package com.crud.loja.dto;

import com.crud.loja.domain.Venda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaDto extends EntidadeId{

    @NotNull
    @Valid
    private PessoaDto cliente;

    @NotNull
    @Valid
    private PessoaDto vendedor;

    @NotEmpty
    @NotNull
    @Valid
    List<VendaItemDto> itens = new ArrayList<>();

    public VendaDto(Venda venda) {
        super(venda.getId());
        this.cliente = new PessoaDto(venda.getCliente());
        this.vendedor = new PessoaDto(venda.getVendedor());
        this.itens =  venda.getItens().stream().map(VendaItemDto::new).collect(Collectors.toList());
    }

    public VendaDto(Long id, @NotNull @Valid PessoaDto cliente, @NotNull @Valid PessoaDto vendedor, @NotEmpty @NotNull @Valid List<VendaItemDto> itens) {
        super(id);
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }
}
