package Jamal.projetoZero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// anotações necessárias para um Controller
@RestController
@RequestMapping
public class PessoaController {

    // pegar informações
    @GetMapping("/boasvindas") // -> localhost:8080/boasvindas
    public String boasVindas(){
        return "Primeira mensagem nessa rota";
    }

}
