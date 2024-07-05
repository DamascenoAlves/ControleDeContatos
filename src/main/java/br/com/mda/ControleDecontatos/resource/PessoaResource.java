package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.dto.PessoaDTO;
import br.com.mda.ControleDecontatos.dto.PessoaMalaDiretaDTO;
import br.com.mda.ControleDecontatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Grava os registros de uma pessoa")
    @PostMapping
    public ResponseEntity<PessoaDTO> save (@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO newPessoaDTO = pessoaService.save(pessoaDTO);
        if(newPessoaDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(newPessoaDTO);
    }

    @Operation(summary = "Busca registros por ID de Pessoas")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
       PessoaDTO pessoaDTO = pessoaService.findById(id);
       return ResponseEntity.ok(pessoaDTO);
    }

    @Operation(summary = "Busca registros por ID de Pessoas e retorna de forma resumida")
    @GetMapping(value = "maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> findPessoaMalaDireta(@PathVariable Long id){
        PessoaMalaDiretaDTO pessoaMalaDiretaDTO = pessoaService.findPessoaMalaDireta(id);
        return ResponseEntity.ok(pessoaMalaDiretaDTO);
    }

    @Operation(summary = "Busca todos os registros de Pessoas")
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAllPessoas(){
        List<PessoaDTO> pessoaDTOS = pessoaService.findAllPessoas();
        return ResponseEntity.ok(pessoaDTOS);
    }

    @Operation(summary = "Exclui o registro de uma pessoa por ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Atualiza o registro de uma pessoa. Validação por ID")
    @PutMapping (value = "/{id}")
    public ResponseEntity<PessoaDTO> update (@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        pessoaDTO = pessoaService.update(id, pessoaDTO);
        return ResponseEntity.ok(pessoaDTO);
    }
}
