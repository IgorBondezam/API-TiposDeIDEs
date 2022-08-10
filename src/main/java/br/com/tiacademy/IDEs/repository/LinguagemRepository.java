package br.com.tiacademy.IDEs.repository;

import br.com.tiacademy.IDEs.core.CrudRepository;
import br.com.tiacademy.IDEs.domain.Linguagem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinguagemRepository extends CrudRepository<Linguagem, Long> {

    @Query(value = "select l from Linguagem l where l.linguagem = :linguagem")
    List<Linguagem> consultarPelolinguagem(@Param("linguagem") String linguagem);


    Linguagem findBylinguagem(String linguagem);


}
