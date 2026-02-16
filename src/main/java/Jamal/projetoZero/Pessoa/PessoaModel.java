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
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true) // cada elemento deve ser unico na tabela, não permite duplicados
    private String email;

    @Column(name = "idade")
    private int idade;

    @ManyToOne // Várias pessoas para uma função
    @JoinColumn(name = "funcoes_id") // cria uma coluna nessa tabela,exerce com a id da funcao que a pessoa
    private FuncaoModel funcao;

    @Column(name = "cpf", unique = true)
    private String cpf;
}
