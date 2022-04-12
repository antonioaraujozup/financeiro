package br.com.zup.edu.financeiro.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private List<Item> itens;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public NotaFiscal() {
    }

    public NotaFiscal(String numero, BigDecimal total, List<Item> itens) {
        this.numero = numero;
        this.total = total;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<Item> getItens() {
        return itens;
    }
}
