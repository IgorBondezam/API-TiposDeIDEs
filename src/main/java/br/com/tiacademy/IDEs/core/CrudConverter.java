package br.com.tiacademy.IDEs.core;

public interface CrudConverter<T, D> {

    D entidadeParaDTO(T entidade);

    T dtoParaEntidade(D dto);

}
