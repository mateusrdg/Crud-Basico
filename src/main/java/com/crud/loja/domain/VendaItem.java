package com.crud.loja.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Venda venda;

    @ManyToOne
    @JoinColumn
    private Produto produto;

    private BigDecimal quantidade;

    @Transient
    private BigDecimal valorTotal;

    public VendaItem (Long id, Produto produto, BigDecimal quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal(){
        return produto.getValor().multiply(quantidade);
    }
}
