package br.com.mda.ControleDecontatos.repository;

import br.com.mda.ControleDecontatos.dto.PessoaMalaDiretaDTO;
import br.com.mda.ControleDecontatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

    @Query(nativeQuery = true, value = "SELECT id, nome,endereco, cep, cidade, uf " +
            "FROM tb_pessoa " +
            "WHERE id = :id")
    Pessoa findPessoaMalaDireta (Long id);

}
