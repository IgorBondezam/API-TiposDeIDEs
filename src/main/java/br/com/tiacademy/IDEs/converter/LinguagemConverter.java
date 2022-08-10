package br.com.tiacademy.IDEs.converter;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.DTO.LinguagemDTO;
import br.com.tiacademy.IDEs.core.CrudConverter;
import br.com.tiacademy.IDEs.domain.IDEs;
import br.com.tiacademy.IDEs.domain.Linguagem;
import org.springframework.stereotype.Component;

@Component
public class LinguagemConverter implements CrudConverter<Linguagem, LinguagemDTO> {
    @Override
    public LinguagemDTO entidadeParaDTO(Linguagem entidade) {

        var dto = new LinguagemDTO();

        dto.setId(entidade.getId());
        dto.setLinguagem(entidade.getLinguagem());
        dto.setUso(entidade.getUso());

        return dto;

    }

    @Override
    public Linguagem dtoParaEntidade(LinguagemDTO dto) {
        var entidade = new Linguagem();

        entidade.setId(dto.getId());
        entidade.setLinguagem(dto.getLinguagem());
        entidade.setUso(dto.getUso());

        return entidade;
    }
}
