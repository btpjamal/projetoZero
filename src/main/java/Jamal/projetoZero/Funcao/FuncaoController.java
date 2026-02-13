package Jamal.projetoZero.Funcao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funcoes")
public class FuncaoController {

    @PostMapping("/criar")
    public String criarFuncao() {
        return "Criar função";
    }

    @GetMapping("/listar")
    public String listarFuncoes() {
        return "Listar funções";
    }

    @GetMapping("/listar/{id}")
    // essa função é do tipo objeto



    @PutMapping("/alterar")
    public String alterarFuncao() {
        return "Alterar função";
    }

    @DeleteMapping("/deletar")
    public String deletarFuncao() {
        return "Deletar função";
    }
}
