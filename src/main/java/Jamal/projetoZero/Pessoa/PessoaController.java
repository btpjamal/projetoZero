package Jamal.projetoZero.Pessoa;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// anotações necessárias para um Controller
@RestController
@RequestMapping("pessoa")
public class PessoaController {

    // injetar o serviço para acessar as regras de negócio
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

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
    public List<PessoaModel> mostrarTodasAsPessoas(){
        return pessoaService.listarPessoas();
    }

    // Mostrar uma pessoa por ID (READ)
    @GetMapping("/listar/{id}")
    public PessoaModel mostrarPessoaID(@PathVariable Long id){
        return pessoaService.listarPessoaPorID(id);
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
