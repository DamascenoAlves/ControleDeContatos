package br.com.mda.ControleDecontatos.service;

import br.com.mda.ControleDecontatos.dto.PessoaDTO;
import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO save(PessoaDTO pessoaDTO){
        //validacao de campos nulos
        if(pessoaDTO.getNome() == null){
            System.out.println("Nome vazio.");
            return null;
        }

        Pessoa pessoa = new Pessoa();
        copyDtoToEntity(pessoaDTO,pessoa);

        //gravar
        try{
            pessoa = pessoaRepository.save(pessoa);
            return new PessoaDTO(pessoa);
        }catch (Exception e){
            System.out.println("ERR: erro ao inserir o produto" + pessoa.toString()+ ": " + e.getMessage());
            return null;
        }
    }



    private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
        entity.setNome(dto.getNome());
        entity.setEndereco(dto.getEndereco());
        entity.setCEP(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setUF(dto.getUf());
    }
}
