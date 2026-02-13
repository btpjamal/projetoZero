package Jamal.projetoZero.Funcao;

import Jamal.projetoZero.Funcao.FuncaoModel;
import Jamal.projetoZero.Funcao.FuncaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoService {

    // injetando o repositório para acessar os dados
    private FuncaoRepository funcaoRepository;

    public FuncaoService(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }
    // Inserir nova Funcao (CREATE)
    public FuncaoModel inserirFuncao(FuncaoModel funcao) {
        return funcaoRepository.save(funcao);
    }

    //Listar todas as Funcaos (READ)
    public List<FuncaoModel> listarFuncaos() {
        return funcaoRepository.findAll();
    }

    // Listar Funcao por ID (READ)
    public FuncaoModel listarFuncaoPorID(Long id) {
        return funcaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcao não encontrada com ID: " + id));
    }

    // Atualizar Funcao por ID (UPDATE)
    public FuncaoModel atualizarFuncao(Long id, FuncaoModel FuncaoAtualizada) {
        FuncaoModel FuncaoExistente = funcaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcao não encontrada com ID: " +
                        id));
        FuncaoExistente.setNomeFuncao(FuncaoAtualizada.getNomeFuncao());
        FuncaoExistente.setClassificacaoFuncional(FuncaoAtualizada.getClassificacaoFuncional());
        return funcaoRepository.save(FuncaoExistente);
    }

    // Deletar Funcao por ID (DELETE)
    public void deletarFuncao(Long id) {
        funcaoRepository.deleteById(id);
    }
}
