package br.com.tiacademy.IDEs.converter;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.core.CrudConverter;
import br.com.tiacademy.IDEs.domain.IDEs;
import org.springframework.stereotype.Component;

@Component
public class IDEsConverter implements CrudConverter<IDEs, IDEsDTO> {


    @Override
    public IDEsDTO entidadeParaDTO(IDEs entidade) {

        var dto = new IDEsDTO();

        dto.setId(entidade.getId());
        dto.setNome(entidade.getNome());
        dto.setLinguagem(entidade.getLinguagem());
        dto.setEmpresa(entidade.getEmpresa());

        return dto;

    }

    @Override
    public IDEs dtoParaEntidade(IDEsDTO dto) {
        var entidade = new IDEs();

        entidade.setId(dto.getId());
        entidade.setNome(dto.getNome());
        entidade.setLinguagem(dto.getLinguagem());
        entidade.setEmpresa(dto.getEmpresa());

        return entidade;
    }


}
