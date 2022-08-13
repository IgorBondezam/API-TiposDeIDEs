package br.com.tiacademy.IDEs.DTO;

import br.com.tiacademy.IDEs.domain.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class IDEsDTO implements Serializable {
    private Long id;

    private String nome;
    private String linguagem;
    private String empresa;

    private List<LinguagemDTO> idLinguagem = new ArrayList<>();


}
