package br.com.tiacademy.IDEs.service;


import br.com.tiacademy.IDEs.core.CrudService;
import br.com.tiacademy.IDEs.domain.IDEs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IDEsService extends CrudService<IDEs, Long> {

    @Override
    protected IDEs editarEntidade(IDEs pegar, IDEs entidade){

        pegar.setNome(entidade.getNome());
        pegar.setEmpresa(entidade.getEmpresa());
        pegar.setLinguagem(entidade.getLinguagem());

        return pegar;
    }
}
