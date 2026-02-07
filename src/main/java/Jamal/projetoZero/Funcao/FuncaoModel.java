package Jamal.projetoZero.Funcao;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_funcao")
public class FuncaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeFuncao;
    private String ClassificacaoFuncional;

    public FuncaoModel() {
    }

    public FuncaoModel(long id, String nomeFuncao, String classificacaoFuncional) {
        this.id = id;
        this.nomeFuncao = nomeFuncao;
        ClassificacaoFuncional = classificacaoFuncional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public String getClassificacaoFuncional() {
        return ClassificacaoFuncional;
    }

    public void setClassificacaoFuncional(String classificacaoFuncional) {
        ClassificacaoFuncional = classificacaoFuncional;
    }
}
