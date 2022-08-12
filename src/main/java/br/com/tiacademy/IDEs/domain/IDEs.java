package br.com.tiacademy.IDEs.domain;

import br.com.tiacademy.IDEs.core.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IDEs implements Serializable, CrudDomain<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String linguagem;
    private String empresa;

    @OneToMany(mappedBy = "linguagemId")
    private List<Linguagem> idLinguagem = new ArrayList<>();

}
