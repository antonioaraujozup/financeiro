package br.com.zup.edu.financeiro.api.repository;

import br.com.zup.edu.financeiro.api.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
}
