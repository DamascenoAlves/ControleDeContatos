package br.com.mda.ControleDecontatos.dto;

import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.model.enums.TipoContato;
import jakarta.persistence.*;

public class ContatoDTO {

    private Long id;
    private TipoContato tipoContato;
    private String contato;

    public ContatoDTO() {
    }

    public ContatoDTO(Long id, TipoContato tipoContato, String contato) {
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
    public String toString() {
        return "ContatoDTO{" +
                "id=" + id +
                ", tipoContato=" + tipoContato +
                ", contato='" + contato +
                '}';
    }
}
