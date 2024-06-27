package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.dto.PessoaDTO;
import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> save (@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO newPessoaDTO = pessoaService.save(pessoaDTO);
        if(newPessoaDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoaDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
       PessoaDTO pessoaDTO = pessoaService.findById(id);
       return ResponseEntity.ok(pessoaDTO);
    }
}
