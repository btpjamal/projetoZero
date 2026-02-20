package Jamal.projetoZero.Funcao;

import Jamal.projetoZero.Funcao.FuncaoModel;
import Jamal.projetoZero.Funcao.FuncaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoService {

    // injetando o repositório para acessar os dados
    private FuncaoRepository funcaoRepository;

    private FuncaoMapper funcaoMapper; // injetando o mapper para converter entre FuncaoModel e FuncaoDTO


    // Construtor para injetar o FuncaoMapper
    public FuncaoService(FuncaoRepository funcaoRepository, FuncaoMapper funcaoMapper)
    {
        this.funcaoRepository = funcaoRepository;
        this.funcaoMapper = funcaoMapper; // inicializa o mapper
    }

    // Inserir nova Funcao (CREATE)
    public FuncaoDTO inserirFuncao(FuncaoDTO funcao) {
        FuncaoModel funcaoModel = funcaoMapper.map(funcao); // converte DTO para Model
        FuncaoModel funcaoSalva = funcaoRepository.save(funcaoModel); // salva no banco de dados
        return funcaoMapper.map(funcaoSalva);
    }

    // Listar todas as Funcoes (READ)
    public List<FuncaoDTO> listarFuncaos() {
        return funcaoRepository.findAll()
                .stream()
                .map(funcaoMapper::map)
                .toList();
    }

    // Listar Funcao por ID (READ)
    public FuncaoDTO listarFuncaoPorID(Long id) {
        FuncaoModel funcao = funcaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcao não encontrada com ID: " + id));
        return funcaoMapper.map(funcao);
    }

    // Atualizar Funcao por ID (UPDATE)
    public FuncaoDTO atualizarFuncao(Long id, FuncaoDTO funcaoAtualizada) {
        FuncaoModel funcaoExistente = funcaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcao não encontrada com ID: " + id));

        funcaoExistente.setNomeFuncao(funcaoAtualizada.getNomeFuncao());
        funcaoExistente.setClassificacaoFuncional(funcaoAtualizada.getClassificacaoFuncional());

        FuncaoModel funcaoSalva = funcaoRepository.save(funcaoExistente);
        return funcaoMapper.map(funcaoSalva);
    }

    // Deletar Funcao por ID (DELETE)
    public void deletarFuncao(Long id) {
        funcaoRepository.deleteById(id);
    }
}
