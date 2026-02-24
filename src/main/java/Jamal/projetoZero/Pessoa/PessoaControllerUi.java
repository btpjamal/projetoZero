package Jamal.projetoZero.Pessoa;

import Jamal.projetoZero.Funcao.FuncaoDTO;
import Jamal.projetoZero.Funcao.FuncaoModel;
import Jamal.projetoZero.Funcao.FuncaoRepository;
import Jamal.projetoZero.Funcao.FuncaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static java.util.Arrays.stream;
import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Controller
@RequestMapping("/pessoa/ui")
public class PessoaControllerUi {

    private final PessoaService pessoaService;
    private final FuncaoRepository funcaoRepository;

    public PessoaControllerUi(PessoaService pessoaService, FuncaoRepository funcaoRepository) {
        this.pessoaService = pessoaService;
        this.funcaoRepository = funcaoRepository;
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("pessoa", new PessoaDTO());
        model.addAttribute("funcoes", funcaoRepository.findAll());
        return "cadastrarPessoa"; // template Thymeleaf
    }

    // Adicionar (CREATE)
    @PostMapping("/cadastrar")
    public String criarPessoa(@ModelAttribute PessoaDTO pessoa) {
        pessoaService.inserirPessoa(pessoa);
        return "redirect:/menu"; // redirecionar para o menu após o cadastro bem-sucedido
    }

    // Mostrar tudo (READ)
    @GetMapping("/listar")
    public String mostrarTodasAsPessoas(Model model){
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        model.addAttribute("pessoas", pessoas);
        return "listarPessoas"; // nome da página HTML para exibir a lista de pessoas
    }

    // Mostrar uma pessoa por ID (READ)
    @GetMapping("/listar/{id}")
    public String mostrarPessoaID(@PathVariable Long id, Model model){
        PessoaDTO pessoa = pessoaService.listarPessoaPorID(id);
        if (pessoa != null) {
            model.addAttribute("pessoa", pessoa);
            return "listarPessoaID"; // nome da página HTML para exibir os detalhes da pessoa
        } else {
            model.addAttribute("pessoa", pessoa);
            return "redirect: /pessoa/ui/listar"; // redirecionar para a lista de pessoas se a pessoa com o ID fornecido não for encontrada
        }
    }


    // Exibir formulário de edição
    @GetMapping("/alterar/{id}")
    public String formularioAlterar(@PathVariable Long id, Model model) {
        PessoaDTO pessoa = pessoaService.listarPessoaPorID(id);
        if (pessoa != null) {
            model.addAttribute("pessoa", pessoa);
            List<FuncaoModel> funcoes = funcaoRepository.findAll(); // busca todas as funções para preencher o dropdown
            model.addAttribute("funcoes", funcoes);
            return "alterarPessoa"; // formulário editável
        }
        return "redirect:/pessoa/ui/listar";
    }

    // Processar atualização
    @PostMapping("/alterar/{id}")
    public String alterarPessoa(@PathVariable Long id,
                                @ModelAttribute PessoaDTO pessoaAtualizada,
                                RedirectAttributes redirect) {
        pessoaService.atualizarPessoa(id, pessoaAtualizada);
        redirect.addFlashAttribute("mensagem", "Pessoa atualizada com sucesso!");
        return "redirect:/pessoa/ui/listar";
    }


    // Deletar pessoa por ID (DELETE)
    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return "redirect:/pessoa/ui/listar"; // redirecionar para a lista de pessoas após a exclusão
    }
}
