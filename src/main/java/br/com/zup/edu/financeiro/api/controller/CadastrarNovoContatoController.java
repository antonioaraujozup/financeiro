package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Contato;
import br.com.zup.edu.financeiro.api.repository.ContatoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoContatoController {

    private final ContatoRepository repository;

    public CadastrarNovoContatoController(ContatoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/api/contatos")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ContatoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Contato novoContato = request.paraContato();

        repository.save(novoContato);

        URI location = uriComponentsBuilder.path("/api/contatos/{id}")
                .buildAndExpand(novoContato.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
