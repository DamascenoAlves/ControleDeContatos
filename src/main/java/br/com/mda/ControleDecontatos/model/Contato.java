package br.com.mda.ControleDecontatos.model;

import br.com.mda.ControleDecontatos.model.enums.TipoContato;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private TipoContato tipoContato;
    @Column(nullable = false)
    private String contato;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Contato() {
    }

    public Contato(Long id, TipoContato tipoContato, String contato) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contato contato = (Contato) o;
        return id.equals(contato.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", tipoContato=" + tipoContato +
                ", contato='" + contato + '\'' +
                '}';
    }
}
