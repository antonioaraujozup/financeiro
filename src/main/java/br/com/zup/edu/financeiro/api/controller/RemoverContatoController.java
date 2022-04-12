package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Contato;
import br.com.zup.edu.financeiro.api.repository.ContatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class RemoverContatoController {

    private final ContatoRepository repository;

    public RemoverContatoController(ContatoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @DeleteMapping("/api/contatos/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        Contato contato = repository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado");
        });

        repository.delete(contato);

        return ResponseEntity.noContent().build();
    }
}
