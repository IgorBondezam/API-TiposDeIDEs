package br.com.tiacademy.IDEs.core;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract interface CrudRepository<T, ID>  extends JpaRepository<T, ID> {

}
