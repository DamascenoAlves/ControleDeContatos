package br.com.mda.ControleDecontatos.dto;

import br.com.mda.ControleDecontatos.model.Pessoa;

public class PessoaMalaDiretaDTO {
    private Long id;
    private String nome;
    private String malaDireta;

    public PessoaMalaDiretaDTO() {
    }

    public PessoaMalaDiretaDTO(Long id, String nome, String malaDireta) {
        this.id = id;
        this.nome = nome;
        this.malaDireta = malaDireta;
    }

    public PessoaMalaDiretaDTO(Pessoa pessoa){
        id = pessoa.getId();
        nome = pessoa.getNome();
        malaDireta = pessoa.getEndereco() + " - CEP: "+ pessoa.getCEP() +" - "+ pessoa.getCidade()+"/"+pessoa.getUf();
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

    public String getMalaDireta() {
        return malaDireta;
    }

    public void setMalaDireta(String malaDireta) {
        this.malaDireta = malaDireta;
    }

    @Override
    public String toString() {
        return "PessoaMalaDiretaDTO{" +
                "id=" + id +
                ", nome='" + nome +
                ", malaDireta='" + malaDireta +
                '}';
    }
}
