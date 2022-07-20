package br.com.tiacademy.IDEs.repository;

import br.com.tiacademy.IDEs.core.CrudRepository;
import br.com.tiacademy.IDEs.domain.IDEs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDEsRepository extends CrudRepository<IDEs, Long> {
}
