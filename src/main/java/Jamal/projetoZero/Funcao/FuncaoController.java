package Jamal.projetoZero.Funcao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FuncaoController {

    @GetMapping("/funcao")
    public String teste(){
        return "teste teste";
    }
}
