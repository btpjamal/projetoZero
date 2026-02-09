package Jamal.projetoZero.Funcao;

import Jamal.projetoZero.Pessoa.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data // Getters & Setters

@Entity
@Table(name = "tb_funcao")
public class FuncaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFuncao;
    private String ClassificacaoFuncional;

    // Uma função para várias pessoas
    @OneToMany(mappedBy = "funcao") // mappedBy: mapeia cada pessoa por função
    private List<PessoaModel> pessoas;
}
