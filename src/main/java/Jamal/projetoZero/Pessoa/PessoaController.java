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


    // Adicionar (CREATE)
    @PostMapping("/criar")
    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoaModel){
        return pessoaService.inserirPessoa(pessoaModel);
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
    @PutMapping("/alterar/{id}")
    public PessoaModel alterarPessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaAtualizada){
        return pessoaService.atualizarPessoa(id, pessoaAtualizada);
    }

    // Deletar pessoa por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
    }
}
