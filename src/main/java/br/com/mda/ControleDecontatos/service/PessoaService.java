package br.com.mda.ControleDecontatos.service;

import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa){
        //validacao de campos nulos
        if(pessoa.getNome() == null){
            System.out.println("Nome vazio.");
            return null;
        }

        //gravar
        try{
            return pessoaRepository.save(pessoa);
        }catch (Exception e){
            System.out.println("ERR: erro ao inserir o produto" + pessoa.toString()+ ": " + e.getMessage());
            return null;
        }
    }

}
