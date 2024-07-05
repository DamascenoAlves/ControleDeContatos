package br.com.mda.ControleDecontatos.resource;


import br.com.mda.ControleDecontatos.configuration.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Operation (summary = "Gera um Bearer token para acesso às requisições HTTP da API")
    @GetMapping("/token") //http://localhost:8081/token?username=NOME
    public ResponseEntity<?> createToken(@RequestParam String username){
        String token = jwtTokenUtil.createToken(username);
        return ResponseEntity.ok(token);
    }

}