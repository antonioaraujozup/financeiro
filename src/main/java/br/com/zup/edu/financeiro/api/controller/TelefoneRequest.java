package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Telefone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TelefoneRequest {

    @NotBlank
    private String tipo;

    @NotBlank
    @Pattern(regexp = "^\\+[1-9][0-9]\\d{1,14}$")
    private String numero;

    public TelefoneRequest(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public Telefone paraTelefone() {
        return new Telefone(tipo,numero);
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }
}
