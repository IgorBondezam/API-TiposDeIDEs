package br.com.tiacademy.IDEs.repository;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.core.CrudConverter;
import br.com.tiacademy.IDEs.core.CrudRepository;
import br.com.tiacademy.IDEs.domain.IDEs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDEsRepository extends CrudRepository<IDEs, Long> {

    @Query(value = "select i from IDEs i where i.nome = :nome")
    List<IDEs> consultarPeloNome(@Param("nome")String nome);


    List<IDEs> findByNome(String nome);


    @Query(value = "select * from ides i order by linguagem asc", nativeQuery = true)
    List<IDEs> findAllNative();


}
