package br.com.mda.ControleDecontatos.dto;

import br.com.mda.ControleDecontatos.model.Contato;
import br.com.mda.ControleDecontatos.model.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContatoDTO {

    private Long id;
    @NotNull(message = "Campo requerido")
    private TipoContato tipoContato;
    @Size(min = 10, max = 11, message = "Necessário inserir no formato DDD(2 caracteres) + número telefônico(8 ou 9 caracteres)")
    @NotBlank(message = "Campo requerido")
    private String contato;

    private PessoaDTO pessoa;

    public ContatoDTO() {
    }

    public ContatoDTO(Long id, TipoContato tipoContato, String contato, PessoaDTO pessoaDTO) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.pessoa = pessoaDTO;
    }

    public ContatoDTO(Contato contato) {
        this.id = contato.getId();
        this.tipoContato = contato.getTipoContato();
        this.contato = contato.getContato();
        this.pessoa = new PessoaDTO(contato.getPessoa());
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

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoaDTO(PessoaDTO pessoaDTO) {
        this.pessoa = pessoa;
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
