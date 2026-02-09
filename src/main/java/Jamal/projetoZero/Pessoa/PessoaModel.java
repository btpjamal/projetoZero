package Jamal.projetoZero.Pessoa;

import Jamal.projetoZero.Funcao.FuncaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity //Transforma uma classe em uma entidade do banco de dados
@Table(name = "tb_cadastro")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    @ManyToOne // Várias pessoas para uma função
    @JoinColumn(name = "funcoes_id") // cria uma coluna nessa tabela,exerce com a id da funcao que a pessoa
    private FuncaoModel funcao;
}
