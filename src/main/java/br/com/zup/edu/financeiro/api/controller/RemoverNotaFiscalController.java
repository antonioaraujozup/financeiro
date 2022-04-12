package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.NotaFiscal;
import br.com.zup.edu.financeiro.api.repository.NotaFiscalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@RestController
public class RemoverNotaFiscalController {

    private final NotaFiscalRepository repository;

    public RemoverNotaFiscalController(NotaFiscalRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @DeleteMapping("/api/notas-fiscais/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        NotaFiscal notaFiscal = repository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota fiscal não encontrada.");
        });

        repository.delete(notaFiscal);

        return ResponseEntity.noContent().build();
    }
}
