package br.com.zup.edu.financeiro.api.controller;

import br.com.zup.edu.financeiro.api.model.Produto;
import br.com.zup.edu.financeiro.api.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class CadastrarNovoProdutoController {

    private final ProdutoRepository repository;

    public CadastrarNovoProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ProdutoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Produto novoProduto = request.paraProduto();

        repository.save(novoProduto);

        URI location = uriComponentsBuilder.path("/produtos/{id}")
                .buildAndExpand(novoProduto.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
