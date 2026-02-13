package Jamal.projetoZero.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository -> "facilitador" semelhante ao lombok
// 1 atributo -> classe a ser escaneada
// 2 atributo -> tipo de dado do ID da classe escaneada
// Essa interface é responsável por acessar os dados da tabela "pessoa" no banco de dados
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
