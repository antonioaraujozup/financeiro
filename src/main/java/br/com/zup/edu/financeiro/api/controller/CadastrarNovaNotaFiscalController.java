package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.NotaFiscal;
import br.com.zup.edu.financeiro.api.repository.NotaFiscalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovaNotaFiscalController {

    private final NotaFiscalRepository repository;

    public CadastrarNovaNotaFiscalController(NotaFiscalRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/api/notas-fiscais")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NotaFiscalRequest request, UriComponentsBuilder uriComponentsBuilder) {

        NotaFiscal notaFiscal = request.paraNotaFiscal();

        repository.save(notaFiscal);

        URI location = uriComponentsBuilder.path("/api/notas-fiscais/{id}")
                .buildAndExpand(notaFiscal.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
