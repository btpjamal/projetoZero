package Jamal.projetoZero.Pessoa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    // injetando o repositório para acessar os dados
    private PessoaRepository pessoaRepository;
    // injetando o mapper para converter entre PessoaModel e PessoaDTO
    private PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // Inserir nova pessoa (CREATE)
    public PessoaDTO inserirPessoa(PessoaDTO pessoa) {
        PessoaModel pessoaModel = pessoaMapper.map(pessoa); // converte DTO para Model
        PessoaModel pessoaSalva = pessoaRepository.save(pessoaModel); // salva no banco de dados
        return pessoaMapper.map(pessoaSalva); // converte Model de volta para DTO e retorna
    }

    //Listar todas as pessoas (READ)
    public List<PessoaDTO> listarPessoas() {
        List<PessoaModel> pessoas = pessoaRepository.findAll(); // busca todas as pessoas no banco de dados
        return pessoaMapper.map(pessoas); // converte a lista de Model para lista de DTO e retorna
    }

    // Listar pessoa por ID (READ)
    public PessoaDTO listarPessoaPorID(Long id) {
        PessoaModel pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id)); // busca a pessoa por ID, lança exceção se não encontrar
        return pessoaMapper.map(pessoa); // converte o Model para DTO e retorna
    }


    // Atualizar pessoa por ID (UPDATE)
    public PessoaDTO atualizarPessoa(Long id, PessoaModel pessoaAtualizada) {
        PessoaModel pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id)); // busca a pessoa por ID, lança exceção se não encontrar

        // Atualiza os campos da pessoa existente com os dados da pessoa atualizada
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setIdade(pessoaAtualizada.getIdade());
        // ... atualize outros campos conforme necessário

        PessoaModel pessoaSalva = pessoaRepository.save(pessoaExistente); // salva as alterações no banco de dados
        return pessoaMapper.map(pessoaSalva); // converte o Model atualizado para DTO e retorna
    }

        // Deletar pessoa por ID (DELETE)
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

}
