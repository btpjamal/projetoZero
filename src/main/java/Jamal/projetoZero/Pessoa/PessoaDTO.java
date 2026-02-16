package Jamal.projetoZero.Pessoa;

import Jamal.projetoZero.Funcao.FuncaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private FuncaoModel funcao;
    private String cpf;
}
