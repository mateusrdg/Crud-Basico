package com.crud.loja.dto;

import com.crud.loja.domain.VendaItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaItemDto extends EntidadeId{

    @NotNull
    @Valid
    private ProdutoDto produto;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "{valor.decimalmin.not.valid}")
    private BigDecimal quantidade;

    public VendaItemDto(VendaItem item) {
        super(item.getId());
        this.produto = new ProdutoDto(item.getProduto());
        this.quantidade = item.getQuantidade();
    }

    public VendaItemDto(Long id, ProdutoDto produto, BigDecimal quantidade) {
        super(id);
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
