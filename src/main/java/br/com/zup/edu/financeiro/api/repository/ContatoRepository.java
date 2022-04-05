package br.com.zup.edu.financeiro.api.repository;

import br.com.zup.edu.financeiro.api.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
