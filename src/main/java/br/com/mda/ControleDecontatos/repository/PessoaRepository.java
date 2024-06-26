package br.com.mda.ControleDecontatos.repository;

import br.com.mda.ControleDecontatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
}
