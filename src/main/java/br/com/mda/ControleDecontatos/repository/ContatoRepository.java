package br.com.mda.ControleDecontatos.repository;

import br.com.mda.ControleDecontatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    @Query(nativeQuery = true, value = "SELECT id, contato, tipo_contato,pessoa_id " +
            "FROM tb_contato " +
            "where tb_contato.pessoa_id = :id")
    List<Contato> findContatosByPessoaId(Long id);
}
