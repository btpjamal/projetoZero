package Jamal.projetoZero.Pessoa;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PessoaMapper {

    public PessoaModel map(PessoaDTO pessoaDTO) {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setEmail(pessoaDTO.getEmail());
        pessoaModel.setIdade(pessoaDTO.getIdade());
        pessoaModel.setFuncao(pessoaDTO.getFuncao());
        pessoaModel.setCpf(pessoaDTO.getCpf());
        return pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setEmail(pessoaModel.getEmail());
        pessoaDTO.setIdade(pessoaModel.getIdade());
        pessoaDTO.setFuncao(pessoaModel.getFuncao());
        pessoaDTO.setCpf(pessoaModel.getCpf());
        return pessoaDTO;
    }

    public List<PessoaDTO> map(List<PessoaModel> pessoas) {
        return pessoas.stream()
                .map(this::map) // converte cada PessoaModel para PessoaDTO usando o método map acima
                .toList(); // coleta os resultados em uma lista
    }
}
