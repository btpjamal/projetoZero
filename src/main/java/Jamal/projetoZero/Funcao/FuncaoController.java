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
    public ResponseEntity<FuncaoModel> criarFuncao(@RequestBody FuncaoModel funcao) {
        FuncaoModel novaFuncao = funcaoService.inserirFuncao(funcao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFuncao);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncaoModel>> listarFuncoes() {
        List<FuncaoModel> funcoes = funcaoService.listarFuncaos();
        return ResponseEntity.ok(funcoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<FuncaoModel> listarFuncaoPorId(@PathVariable Long id) {
        FuncaoModel funcao = funcaoService.listarFuncaoPorID(id);
        return ResponseEntity.ok(funcao);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<FuncaoModel> alterarFuncao(@PathVariable Long id, @RequestBody FuncaoModel funcaoAtualizada) {
        FuncaoModel funcaoModificada = funcaoService.atualizarFuncao(id, funcaoAtualizada);
        return ResponseEntity.ok(funcaoModificada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarFuncao(@PathVariable Long id) {
        funcaoService.deletarFuncao(id);
        return ResponseEntity.noContent().build();
    }
}
