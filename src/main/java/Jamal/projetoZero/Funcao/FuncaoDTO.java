package Jamal.projetoZero.Funcao;

import Jamal.projetoZero.Pessoa.PessoaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncaoDTO {


    private Long id;
    private String nomeFuncao;
    private String ClassificacaoFuncional;
    private List<PessoaModel> pessoas;
}
