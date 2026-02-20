package Jamal.projetoZero.Funcao;

import Jamal.projetoZero.Pessoa.PessoaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data // Getters & Setters
@ToString

@Entity
@Table(name = "tb_funcao")
public class FuncaoModel {
    @Id
    @Column(name = "id_funcoes")
    private Long id;

    @Column(name = "nome_funcao")
    private String nomeFuncao;

    @Column(name = "classificacao_funcional")
    private String ClassificacaoFuncional;

    // Uma função para várias pessoas
    @OneToMany(mappedBy = "funcao") // mappedBy: mapeia cada pessoa por função
    @JsonIgnore // Ignorar a lista de pessoas ao serializar a função para evitar recursão infinita
    private List<PessoaModel> pessoas;
}
