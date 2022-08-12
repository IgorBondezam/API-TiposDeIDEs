package br.com.tiacademy.IDEs.core;

import java.util.List;

public interface CrudConverter<T, D> {

    D entidadeParaDTO(T entidade);

    T dtoParaEntidade(D dto);

}
