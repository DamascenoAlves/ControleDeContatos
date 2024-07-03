package br.com.mda.ControleDecontatos.service;

import br.com.mda.ControleDecontatos.dto.ContatoDTO;
import br.com.mda.ControleDecontatos.model.Contato;
import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

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
            return new ContatoDTO(contato);
        }catch (Exception e){
            System.out.println("ERR: erro ao inserir o produto" + contato.toString()+ ": " + e.getMessage());
            return null;
        }
    }

    private void copyDtoToEntity(ContatoDTO dto, Contato entity) {
        entity.setId(dto.getId());
        entity.setContato(dto.getContato());
        entity.setTipoContato(dto.getTipoContato());
        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getPessoa().getId());
        entity.setPessoa(pessoa);
    }
}
