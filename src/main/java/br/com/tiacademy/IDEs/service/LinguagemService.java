package br.com.tiacademy.IDEs.service;

import br.com.tiacademy.IDEs.core.CrudService;
import br.com.tiacademy.IDEs.domain.Linguagem;
import org.springframework.stereotype.Service;

@Service
public class LinguagemService extends CrudService<Linguagem, Long> {
    @Override
    protected Linguagem editarEntidade(Linguagem pegar, Linguagem entidade) {

        pegar.setLinguagem(entidade.getLinguagem());
        pegar.setUso(entidade.getUso());
        pegar.setLinguagem_id(entidade.getLinguagem_id());

        return pegar;
    }
}
