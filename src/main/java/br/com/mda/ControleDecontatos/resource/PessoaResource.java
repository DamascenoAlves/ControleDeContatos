package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.dto.PessoaDTO;
import br.com.mda.ControleDecontatos.dto.PessoaMalaDiretaDTO;
import br.com.mda.ControleDecontatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> findPessoaMalaDireta(@PathVariable Long id){
        PessoaMalaDiretaDTO pessoaMalaDiretaDTO = pessoaService.findPessoaMalaDireta(id);
        return ResponseEntity.ok(pessoaMalaDiretaDTO);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAllPessoas(){
        List<PessoaDTO> pessoaDTOS = pessoaService.findAllPessoas();
        return ResponseEntity.ok(pessoaDTOS);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<PessoaDTO> update (@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        pessoaDTO = pessoaService.update(id, pessoaDTO);
        return ResponseEntity.ok(pessoaDTO);
    }
}
