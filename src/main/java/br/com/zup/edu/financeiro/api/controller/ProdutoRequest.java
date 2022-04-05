package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal valor;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Produto paraProduto() {
        return new Produto(nome,valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
