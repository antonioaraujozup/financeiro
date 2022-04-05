package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Item;
import br.com.zup.edu.financeiro.api.model.NotaFiscal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class NotaFiscalRequest {

    @NotBlank
    private String numero;

    @NotNull
    @Positive
    private BigDecimal total;

    @NotEmpty
    private List<@Valid ItemRequest> itens;

    public NotaFiscalRequest(String numero, BigDecimal total, List<@Valid ItemRequest> itens) {
        this.numero = numero;
        this.total = total;
        this.itens = itens;
    }

    public NotaFiscal paraNotaFiscal() {

        List<Item> itensDeNota = itens.stream()
                .map(itemDeNota -> itemDeNota.paraItem())
                .collect(Collectors.toList());

        return new NotaFiscal(numero,total,itensDeNota);

    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemRequest> getItens() {
        return itens;
    }
}
