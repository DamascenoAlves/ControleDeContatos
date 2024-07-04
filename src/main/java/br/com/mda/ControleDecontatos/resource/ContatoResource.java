package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.dto.ContatoDTO;
import br.com.mda.ControleDecontatos.dto.ContatoMinDTO;
import br.com.mda.ControleDecontatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {


    @Autowired
    private ContatoService contatoService;


    @PostMapping
    public ResponseEntity<ContatoDTO> save (@RequestBody ContatoDTO contatoDTO) {
        ContatoDTO newContatoDTO = contatoService.save(contatoDTO);
        if(newContatoDTO == null) return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.CREATED).body(newContatoDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContatoDTO> findById(@PathVariable Long id){
        ContatoDTO contatoDTO = contatoService.findById(id);
        return ResponseEntity.ok(contatoDTO);
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public ResponseEntity<List<ContatoMinDTO>> findContatosByPessoaId (@PathVariable Long idPessoa){
        List<ContatoMinDTO> contatos = contatoService.findContatosByPessoaId(idPessoa);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContatoDTO> update (@PathVariable Long id, @RequestBody ContatoDTO contatoDTO){
                contatoDTO = contatoService.update(id,contatoDTO);
                return ResponseEntity.ok(contatoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
