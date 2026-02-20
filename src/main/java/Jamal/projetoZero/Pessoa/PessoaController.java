package Jamal.projetoZero.Pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// anotações necessárias para um Controller
@RestController
@RequestMapping("pessoa")
public class PessoaController {

    // injetar o serviço para acessar as regras de negócio
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    // Adicionar (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarPessoa(@RequestBody PessoaDTO pessoa) {
        PessoaDTO novaPessoa = pessoaService.inserirPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa criada com sucesso: " + novaPessoa.getNome() + "(ID)" + novaPessoa.getId());
    }

    // Mostrar tudo (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<PessoaDTO>> mostrarTodasAsPessoas(){
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    // Mostrar uma pessoa por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarPessoaID(@PathVariable Long id){
        if(pessoaService.listarPessoaPorID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada para o ID: " + id);
        }
        PessoaDTO pessoa = pessoaService.listarPessoaPorID(id);
        return ResponseEntity.ok(pessoa);
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
