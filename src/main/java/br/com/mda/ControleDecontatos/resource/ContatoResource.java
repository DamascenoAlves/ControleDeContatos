package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.dto.ContatoDTO;
import br.com.mda.ControleDecontatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
