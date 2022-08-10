package br.com.tiacademy.IDEs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinguagemDTO implements Serializable{

    private Long id;

    private String linguagem;
    private String uso;


}
