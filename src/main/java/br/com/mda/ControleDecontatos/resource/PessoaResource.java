package br.com.mda.ControleDecontatos.resource;

import br.com.mda.ControleDecontatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {
    @Autowired
    private PessoaService pessoaService;
}
