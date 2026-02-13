package Jamal.projetoZero.Pessoa;

import org.springframework.web.bind.annotation.*;

// anotações necessárias para um Controller
@RestController
@RequestMapping("pessoa")
public class PessoaController {

    // pegar informações
    @GetMapping("/boasvindas") // -> localhost:8080/boasvindas
    public String boasVindas(){
        return "Primeira mensagem nessa rota";
    }

    // Adicionar (CREATE)
    @PostMapping("/criar")
    public String criarPessoa(){
        return "Criar pessoa";
    }

    // Mostrar tudo (READ)
    @GetMapping("/listar")
    public String mostrarTodasAsPessoas(){
        return "Mostrar todas as pessoas";
    }

    // Mostrar uma pessoa por ID (READ)
    @GetMapping("/buscarID")
    public String mostrarPessoaID(){
        return "Mostrar pessoa por ID";
    }

    // Alterar uma pessoa por ID (UPDATE)
    @PutMapping("/alterar")
    public String alterarPessoaID(){
        return "Alterar pessoa por ID";
    }

    // Deletar pessoa por ID (DELETE)
    @DeleteMapping("/deletar")
    public String deletarPessoaID(){
        return "Deletar pessoa por ID";
    }
}
