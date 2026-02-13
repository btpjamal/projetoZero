package Jamal.projetoZero.Funcao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funcoes")
public class FuncaoController {

    @PostMapping("/criar")
    public String criarFuncao() {
        return "Criar função";
    }

    @PutMapping("/alterar")
    public String alterarFuncao() {
        return "Alterar função";
    }

    @GetMapping("/listar")
    public String listarFuncoes() {
        return "Listar funções";
    }

    @DeleteMapping("/deletar")
    public String deletarFuncao() {
        return "Deletar função";
    }
}
