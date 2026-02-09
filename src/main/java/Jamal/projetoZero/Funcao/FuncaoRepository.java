package Jamal.projetoZero.Funcao;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository -> "facilitador" semelhante ao lombok
// 1 atributo -> classe a ser escaneada
// 2 atributo -> tipo de dado do ID da classe escaneada
public interface FuncaoRepository extends JpaRepository<FuncaoModel, Long> {
}
