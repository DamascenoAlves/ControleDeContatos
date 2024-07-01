package br.com.mda.ControleDecontatos;

import br.com.mda.ControleDecontatos.dto.PessoaMalaDiretaDTO;
import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleDecontatosApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ControleDecontatosApplication.class, args);
	}

}
