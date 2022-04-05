package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Item;
import br.com.zup.edu.financeiro.api.model.Produto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemRequest {

    @NotNull
    private Long produtoId;

    @NotNull
    @Positive
    private Integer quantidade;

    public ItemRequest(Long produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Item paraItem(){
        return new Item(new Produto(produtoId),quantidade);
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
