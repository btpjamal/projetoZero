package Jamal.projetoZero.Funcao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcao/ui")
public class FuncaoControllerUI {

    private FuncaoService funcaoService;


    public FuncaoControllerUI(FuncaoService funcaoService) {
        this.funcaoService = funcaoService;
    }

    @GetMapping("/cadastrar")
    public String mostrarFormulario() {
        return "cadastrarFuncao"; // página HTML com o formulário
    }


    @PostMapping("/cadastrar")
    public String criarFuncao(@ModelAttribute FuncaoDTO funcao) {
        FuncaoDTO novaFuncao = funcaoService.inserirFuncao(funcao);
        return "redirect:/menu"; // redireciona para o menu após criar a função
    }

    @GetMapping("/listar")
    public String listarFuncoes(Model model) {
        List<FuncaoDTO> funcoes = funcaoService.listarFuncoes();
        model.addAttribute("funcoes", funcoes); // adiciona a lista de funções ao modelo
        return "listarFuncoes"; // página HTML para exibir a lista de funções
    }

    @GetMapping("/listar/{id}")
    public String listarFuncaoPorId(@PathVariable Long id, Model model) {
        FuncaoDTO funcao = funcaoService.listarFuncaoPorID(id);
        if (funcao != null) {
            model.addAttribute("funcao", funcao); // adiciona a função ao modelo
            List<FuncaoDTO> pessoas = funcaoService.listarPessoasPorFuncao();
            model.addAttribute("pessoas", pessoas); // adiciona a lista de pessoas ao modelo
            return "listarFuncaoID"; // página HTML para exibir os detalhes da função
        } else {
            return "Função não encontrada"; // ou redirecionar para uma página de erro
        }
    }

    @PutMapping("/alterar/{id}")
    public String alterarFuncao(@PathVariable Long id, @RequestBody FuncaoDTO funcaoAtualizada) {
        if (funcaoService.listarFuncaoPorID(id) == null) {
            return "";
        }
        funcaoService.atualizarFuncao(id, funcaoAtualizada);
        return "redirect:/menu"; // redireciona para o menu após atualizar a função
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarFuncao(@PathVariable Long id) {
        if (funcaoService.listarFuncaoPorID(id) != null) {
            funcaoService.deletarFuncao(id);
            return "redirect:/menu"; // redireciona para o menu após deletar a função
        } else {
            return ""; // ou redirecionar para uma página de erro
        }
    }
}
