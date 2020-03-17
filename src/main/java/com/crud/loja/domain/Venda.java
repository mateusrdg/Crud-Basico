package com.crud.loja.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venda {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @OneToMany(mappedBy = "venda", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    List<VendaItem> itens = new ArrayList<>();

    @Transient
    private BigDecimal valorTotal;

    public Venda(Long id, Cliente cliente, Vendedor vendedor, List<VendaItem> itens) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public BigDecimal getValorTotal(){
        return itens.stream().map(VendaItem::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
