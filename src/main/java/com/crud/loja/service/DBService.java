package com.crud.loja.service;

import com.crud.loja.dto.PessoaDto;
import com.crud.loja.dto.ProdutoDto;
import com.crud.loja.dto.VendaDto;
import com.crud.loja.dto.VendaItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DBService {
    @Autowired
    private  ClienteService clienteService;
    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private VendaService vendaService;

    public void instantiateTestsData (){

        log.info("Instanciando clientes...");
        ArrayList<PessoaDto> clientes = new ArrayList<>();
        clientes.add(new PessoaDto("Mateus"));
        clientes.add(new PessoaDto("Lucas"));
        clientes.add(new PessoaDto("Gabriel"));

        log.info("Inserindo clientes...");
        clientes.forEach(clienteService::insert);

        log.info("Instanciando vendedores...");
        ArrayList<PessoaDto> vendedores = new ArrayList<>();
        vendedores.add(new PessoaDto("Lavigne"));
        vendedores.add(new PessoaDto("Gabrielly"));

        log.info("Inserindo vendedores...");
        vendedores.forEach(vendedorService::insert);

        log.info("Instanciando produtos...");
        ArrayList<ProdutoDto> produtos = new ArrayList<>();
        produtos.add(new ProdutoDto("Bicicleta", new BigDecimal(325.00)));
        produtos.add(new ProdutoDto("Computador", new BigDecimal(7000.00)));
        produtos.add(new ProdutoDto("Sofa", new BigDecimal(1500.00)));
        produtos.add(new ProdutoDto("Camisa", new BigDecimal(100.00)));
        produtos.add(new ProdutoDto("Borracha", new BigDecimal(1.50)));
        produtos.add(new ProdutoDto("Fogão", new BigDecimal(400.00)));
        produtos.add(new ProdutoDto("Televisão", new BigDecimal(2000.00)));

        log.info("Inserindo produtos...");
        produtos.forEach(produtoService::insert);

        log.info("Instanciando vendas");
        ArrayList<VendaDto> vendas = new ArrayList<>();
        List<VendaItemDto> itens1 = new ArrayList<>();
        itens1.add(new VendaItemDto(null, produtoService.find((long)2), new BigDecimal(1.0)));
        vendas.add(new VendaDto(null, clienteService.find((long) 1), vendedorService.find((long)1), itens1));

        List<VendaItemDto> itens2 = new ArrayList<>();
        itens2.add(new VendaItemDto(null, produtoService.find((long)4), new BigDecimal(5.0)));
        itens2.add(new VendaItemDto(null, produtoService.find((long)5), new BigDecimal(10.0)));
        itens2.add(new VendaItemDto(null, produtoService.find((long)6), new BigDecimal(1.0)));
        itens2.add(new VendaItemDto(null, produtoService.find((long)7), new BigDecimal(2.0)));
        vendas.add(new VendaDto(null, clienteService.find((long) 2), vendedorService.find((long)2), itens2));

        List<VendaItemDto> itens3 = new ArrayList<>();
        itens3.add(new VendaItemDto(null, produtoService.find((long)1), new BigDecimal(2.0)));
        itens3.add(new VendaItemDto(null, produtoService.find((long)3), new BigDecimal(1.0)));
        vendas.add(new VendaDto(null, clienteService.find((long) 3), vendedorService.find((long)2), itens3));

        log.info("Inserindo vendas");
        vendas.forEach(vendaService::insert);

    }
}
