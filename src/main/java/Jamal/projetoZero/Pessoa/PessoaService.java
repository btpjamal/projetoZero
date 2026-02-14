package Jamal.projetoZero.Pessoa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    // injetando o repositório para acessar os dados
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // Inserir nova pessoa (CREATE)
    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }

    //Listar todas as pessoas (READ)
    public List<PessoaModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

    // Listar pessoa por ID (READ)
    public PessoaModel listarPessoaPorID(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));
    }


    // Atualizar pessoa por ID (UPDATE)
    public PessoaModel atualizarPessoa(Long id, PessoaModel pessoaAtualizada) {
        PessoaModel pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " +
                        id));
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setIdade(pessoaAtualizada.getIdade());
        return pessoaRepository.save(pessoaExistente);
    }

        // Deletar pessoa por ID (DELETE)
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

}
