package br.com.mda.ControleDecontatos.service;

import br.com.mda.ControleDecontatos.dto.ContatoDTO;
import br.com.mda.ControleDecontatos.dto.ContatoMinDTO;
import br.com.mda.ControleDecontatos.model.Contato;
import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.repository.ContatoRepository;
import br.com.mda.ControleDecontatos.repository.PessoaRepository;
import br.com.mda.ControleDecontatos.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public ContatoDTO save(ContatoDTO contatoDTO){
        //validacao de campos nulos
        if(contatoDTO.getTipoContato() == null){
            System.out.println("Nome vazio.");
            return null;
        }
        if(contatoDTO.getContato() == null){
            System.out.println("Nome vazio.");
            return null;
        }

        //Instanciação da entidade pessoa
        Contato contato = new Contato();
        copyDtoToEntity(contatoDTO,contato);

        //gravar
        try{
            contato = contatoRepository.save(contato);
            contato.setPessoa(pessoaRepository.getReferenceById(contato.getPessoa().getId()));
            return new ContatoDTO(contato);
        }catch (Exception e){
            System.out.println("ERR: erro ao inserir o produto" + contato.toString()+ ": " + e.getMessage());
            return null;
        }
    }

    @Transactional (readOnly = true)
    public ContatoDTO findById(Long id) {
        ContatoDTO contatoDTO = new ContatoDTO(contatoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado - ID: "+ id)));
        return contatoDTO;
    }

    @Transactional
    public List<ContatoMinDTO> findContatosByPessoaId(Long id){
        List<Contato> contatos = contatoRepository.findContatosByPessoaId(id);
        return contatos.stream().map(x -> new ContatoMinDTO(x)).toList();
    }

    @Transactional
    public ContatoDTO update(Long id, ContatoDTO contatoDTO){
        try{
            Contato entity = contatoRepository.getReferenceById(id);
            copyDtoToEntity(contatoDTO,entity);
            entity = contatoRepository.save(entity);
            entity.setPessoa(pessoaRepository.getReferenceById(entity.getPessoa().getId()));
            return new ContatoDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado - ID: "+ id);
        }
    }

    private void copyDtoToEntity(ContatoDTO dto, Contato entity) {
        entity.setContato(dto.getContato());
        entity.setTipoContato(dto.getTipoContato());
        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getPessoa().getId());
        entity.setPessoa(pessoa);
    }
}
