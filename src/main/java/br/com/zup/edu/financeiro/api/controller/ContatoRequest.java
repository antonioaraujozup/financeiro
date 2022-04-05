package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Contato;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ContatoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String empresa;

    @NotEmpty
    private List<@Valid TelefoneRequest> telefones;

    public ContatoRequest(String nome, String empresa, List<TelefoneRequest> telefones) {
        this.nome = nome;
        this.empresa = empresa;
        this.telefones = telefones;
    }

    public Contato paraContato() {
        Contato contato = new Contato(nome,empresa);

        telefones.forEach(t -> {
            contato.adiciona(t.paraTelefone());
        });

        return contato;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public List<TelefoneRequest> getTelefones() {
        return telefones;
    }
}
