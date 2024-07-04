package br.com.mda.ControleDecontatos.service;

import br.com.mda.ControleDecontatos.dto.PessoaDTO;
import br.com.mda.ControleDecontatos.dto.PessoaMalaDiretaDTO;
import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.repository.PessoaRepository;
import br.com.mda.ControleDecontatos.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public PessoaDTO save(PessoaDTO pessoaDTO){
        //validacao de campos nulos
        if(pessoaDTO.getNome() == null){
            System.out.println("Nome vazio.");
            return null;
        }

        //Instanciação da entidade pessoa
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

    @Transactional (readOnly = true)
    public PessoaDTO findById(Long id) {
        PessoaDTO pessoaDTO = new PessoaDTO(pessoaRepository.findById(id)
                                                .orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado - ID: "+ id)));
        return pessoaDTO;

    }

    @Transactional(readOnly = true)
    public PessoaMalaDiretaDTO findPessoaMalaDireta(Long id){
        Pessoa pessoa = pessoaRepository.findPessoaMalaDireta(id);
        PessoaMalaDiretaDTO pessoaMalaDiretaDTO = new PessoaMalaDiretaDTO(pessoa);
        return pessoaMalaDiretaDTO;
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAllPessoas(){
        List<Pessoa> pessoa = pessoaRepository.findAll();
        return pessoa.stream().map(x->new PessoaDTO(x)).toList();
    }

    @Transactional
    public void delete(Long id){
        if (!pessoaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado - ID: "+ id);
        }
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public PessoaDTO update (Long id, PessoaDTO pessoaDTO){
        try{
            Pessoa entity = pessoaRepository.getReferenceById(id);
            copyDtoToEntity(pessoaDTO,entity);
            entity = pessoaRepository.save(entity);
            return new PessoaDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado - ID: "+ id);
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
