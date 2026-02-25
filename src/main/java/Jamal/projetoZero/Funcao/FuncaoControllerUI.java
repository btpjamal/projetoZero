package Jamal.projetoZero.Funcao;

import Jamal.projetoZero.Pessoa.PessoaDTO;
import Jamal.projetoZero.Pessoa.PessoaRepository;
import Jamal.projetoZero.Pessoa.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcao/ui")
public class FuncaoControllerUI {

    private final FuncaoService funcaoService;
    private final PessoaService pessoaService;


    public FuncaoControllerUI(FuncaoService funcaoService, PessoaService pessoaService) {
        this.funcaoService = funcaoService;
        this.pessoaService = pessoaService;
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
    public String mostrarFuncaoID(@PathVariable Long id, Model model){
        FuncaoDTO funcao = funcaoService.listarFuncaoPorID(id);
        if (funcao != null) {
            model.addAttribute("funcao", funcao);
            // Adiciona a lista de pessoas associadas à função ao modelo
            List<PessoaDTO> pessoasAssociadas = pessoaService.findByFuncaoId(id)
                    .stream()
                    .map(pessoa -> new PessoaDTO(pessoa.getId(), pessoa.getNome())) // mapeia para PessoaDTO, omitindo a função para evitar recursão
                    .toList();
            model.addAttribute("pessoasAssociadas", pessoasAssociadas);
            return "listarFuncaoID"; // nome da página HTML para exibir os detalhes da função
        } else {
            return "redirect:/menu"; // ou redirecionar para uma página de erro
        }
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlteracao(@PathVariable Long id, Model model) {
        FuncaoDTO funcao = funcaoService.listarFuncaoPorID(id);
        if (funcao != null) {
            model.addAttribute("funcao", funcao); // adiciona a função ao modelo para preencher o formulário
            return "alterarFuncao"; // página HTML com o formulário de alteração
        }else{
            return "redirect:/menu"; // ou redirecionar para uma página de erro
        }
    }

    @PostMapping("/alterar/{id}")
    public String alterarFuncao(@PathVariable Long id, @ModelAttribute FuncaoDTO funcaoAtualizada) {
        funcaoService.atualizarFuncao(id, funcaoAtualizada);
        return "redirect:/funcao/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncao(@PathVariable Long id) {
        funcaoService.deletarFuncao(id);
        return "redirect:/funcao/ui/listar"; // redireciona para o menu após deletar a função
    }
}
