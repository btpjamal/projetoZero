package Jamal.projetoZero.Funcao;

import org.springframework.stereotype.Component;

@Component
public class FuncaoMapper {
    public FuncaoDTO map(FuncaoModel model) {
        FuncaoDTO dto = new FuncaoDTO();
        dto.setId(model.getId());
        dto.setNomeFuncao(model.getNomeFuncao());
        dto.setClassificacaoFuncional(model.getClassificacaoFuncional());
        dto.setPessoas(model.getPessoas());
        return dto;
    }

    public FuncaoModel map(FuncaoDTO dto) {
        FuncaoModel model = new FuncaoModel();
        model.setId(dto.getId());
        model.setNomeFuncao(dto.getNomeFuncao());
        model.setClassificacaoFuncional(dto.getClassificacaoFuncional());
        model.setPessoas(dto.getPessoas());
        return model;
    }
}
