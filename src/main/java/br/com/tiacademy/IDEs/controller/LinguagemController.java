package br.com.tiacademy.IDEs.controller;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.DTO.LinguagemDTO;
import br.com.tiacademy.IDEs.core.CrudController;
import br.com.tiacademy.IDEs.domain.Linguagem;
import br.com.tiacademy.IDEs.repository.LinguagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/linguagem")
public class LinguagemController extends CrudController<Linguagem, LinguagemDTO, Long> {

    public LinguagemRepository getRepository() {
        return (LinguagemRepository) this.repository;
    }


    //List<Linguagem> findBylinguagem(String linguagem)
    @GetMapping("/java")
    public List<LinguagemDTO> linguagemJ(){
        var linguagems = this.getRepository().findBylinguagem("java");

        var lingDTO = linguagems.stream()
                .map(linguagem -> new LinguagemDTO(linguagem.getId(),
                        linguagem.getLinguagem(),
                        linguagem.getUso()
                )).collect(Collectors.toList());
        return lingDTO;

    }

     //@Query(value = "select l from Linguagem l where l.linguagem = :linguagem")
    @GetMapping("/python")
    public List<LinguagemDTO> linguagemP(){
        var linguagems =this.getRepository().consultarPelolinguagem("python");

        var lingDTO = linguagems.stream()
                .map(linguagem -> new LinguagemDTO(linguagem.getId(),
                        linguagem.getLinguagem(),
                        linguagem.getUso()
                )).collect(Collectors.toList());
        return lingDTO;
    }

    //Lista findAll convertida para dto
    @GetMapping
    public ResponseEntity<List<LinguagemDTO>> listaDto() {
        var linguagems = getRepository().findAll();

        var lingDTO = linguagems.stream()
                .map(linguagem -> new LinguagemDTO(linguagem.getId(),
                        linguagem.getLinguagem(),
                        linguagem.getUso()
                )).collect(Collectors.toList());
        return ResponseEntity.ok(lingDTO);

    }



}
