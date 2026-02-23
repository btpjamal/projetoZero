package Jamal.projetoZero.Pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoa/ui")
public class PessoaControllerUi {

    private final PessoaService pessoaService;

    public PessoaControllerUi(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // Adicionar (CREATE)
    @PostMapping("/criar")
    public String criarPessoa(@RequestBody PessoaDTO pessoa, Model model) {
        PessoaDTO novaPessoa = pessoaService.inserirPessoa(pessoa);
        model.addAttribute("novaPessoa", novaPessoa);
        return "pessoaCriada";
    }

    // Mostrar tudo (READ)
    @GetMapping("/listar")
    public String mostrarTodasAsPessoas(Model model){
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        model.addAttribute("pessoas", pessoas);
        return "ListarPessoas";
    }

    // Mostrar uma pessoa por ID (READ)
    @GetMapping("/listar/{id}")
    public String mostrarPessoaID(@PathVariable Long id, Model model){
        PessoaDTO pessoa = pessoaService.listarPessoaPorID(id);
        if (pessoa != null) {
            model.addAttribute("pessoa", pessoa);
            return "detalhesPessoa";
        } else {
            model.addAttribute("pessoa", pessoa);
            return "ListarPessoas"; // ou uma página de erro personalizada
        }
    }


    // Alterar uma pessoa por ID (UPDATE)
    @PutMapping("/alterar/{id}")
    public String alterarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaAtualizada){
        pessoaService.atualizarPessoa(id, pessoaAtualizada);
        return "redirect:/pessoa/ui/listarPessoas";
    }

    // Deletar pessoa por ID (DELETE)
    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return "redirect:/pessoa/ui/listar";
    }
}
