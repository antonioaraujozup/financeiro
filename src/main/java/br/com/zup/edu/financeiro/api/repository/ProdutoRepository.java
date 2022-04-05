package br.com.zup.edu.financeiro.api.repository;

import br.com.zup.edu.financeiro.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
