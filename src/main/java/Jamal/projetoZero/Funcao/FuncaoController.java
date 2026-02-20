package Jamal.projetoZero.Funcao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcoes")
public class FuncaoController {

    private FuncaoService funcaoService;

    public FuncaoController(FuncaoService funcaoService) {
        this.funcaoService = funcaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncao(@RequestBody FuncaoDTO funcao) {
        FuncaoDTO novaFuncao = funcaoService.inserirFuncao(funcao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nova funcao criada com sucesso: " + novaFuncao.getNomeFuncao() + "(ID)" + novaFuncao.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncaoDTO>> listarFuncoes() {
        List<FuncaoDTO> funcoes = funcaoService.listarFuncaos();
        return ResponseEntity.ok(funcoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarFuncaoPorId(@PathVariable Long id) {
        if (funcaoService.listarFuncaoPorID(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Função não encontrada para o ID: " + id);
        }
        FuncaoDTO funcao = funcaoService.listarFuncaoPorID(id);
        return ResponseEntity.ok(funcao);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFuncao(@PathVariable Long id, @RequestBody FuncaoDTO funcaoAtualizada) {
        if (funcaoService.listarFuncaoPorID(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Função não encontrada para o ID: " + id);
        }
        funcaoService.atualizarFuncao(id, funcaoAtualizada);
        return ResponseEntity.ok(funcaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncao(@PathVariable Long id) {
        if (funcaoService.listarFuncaoPorID(id) != null) {
            funcaoService.deletarFuncao(id);
            return ResponseEntity.ok("Função deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Função não encontrada para o ID: " + id);
        }
    }
}
