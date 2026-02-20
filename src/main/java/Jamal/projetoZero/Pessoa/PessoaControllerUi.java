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
        if(pessoaService.listarPessoaPorID(id) == null){
            model.addAttribute("errorMessage", "Pessoa não encontrada para o ID: " + id);
            return "error";
        }
        PessoaDTO pessoa = pessoaService.listarPessoaPorID(id);
        model.addAttribute("pessoa", pessoa);
        return "ListarPessoasID";
    }


    // Alterar uma pessoa por ID (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaAtualizada){
        if(pessoaService.listarPessoaPorID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada para o ID: " + id);
        }
        pessoaService.atualizarPessoa(id, pessoaAtualizada);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    // Deletar pessoa por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id){
        if(pessoaService.listarPessoaPorID(id) != null){
            pessoaService.deletarPessoa(id);
            return ResponseEntity.ok("Pessoa deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada para o ID: " + id);
        }
    }
}
