package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.model.Pessoa;
import br.com.mda.ControleDecontatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> save (@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.save(pessoa);
        if(newPessoa == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }
}
