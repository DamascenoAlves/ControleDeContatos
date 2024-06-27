package br.com.mda.ControleDecontatos.dto;

import br.com.mda.ControleDecontatos.model.Pessoa;

import java.util.Optional;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String cep;
    private String cidade;
    private String uf;

    public PessoaDTO(Long id, String nome, String endereco, String cep, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa client){
        id = client.getId();
        nome = client.getNome();
        endereco = client.getEndereco();
        cep = client.getCEP();
        cidade = client.getCidade();
        uf = client.getUf();
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "PessoaDTO [" +
                            "id=" + id +
                            ", nome='" + nome +
                            ", endereco='" + endereco  +
                            ", cep='" + cep +
                            ", cidade='" + cidade +
                            ", uf='" + uf +
                            ']';
    }
}
