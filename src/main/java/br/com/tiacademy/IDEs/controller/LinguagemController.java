package br.com.tiacademy.IDEs.controller;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.DTO.LinguagemDTO;
import br.com.tiacademy.IDEs.core.CrudController;
import br.com.tiacademy.IDEs.domain.Linguagem;
import br.com.tiacademy.IDEs.repository.LinguagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/java")
    public Linguagem linguagemJ(){return this.getRepository().findBylinguagem("java");}

    @GetMapping("/python")
    public List<Linguagem> linguagemP(){return this.getRepository().consultarPelolinguagem("python");}


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
