package br.com.tiacademy.IDEs.domain;

import br.com.tiacademy.IDEs.core.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Linguagem implements Serializable, CrudDomain<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String linguagem;
    private String uso;

    @ManyToOne
    @JoinColumn(name = "linguagem_id", referencedColumnName="id")
    private IDEs linguagemId;

}
