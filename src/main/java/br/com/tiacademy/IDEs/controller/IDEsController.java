package br.com.tiacademy.IDEs.controller;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.DTO.LinguagemDTO;
import br.com.tiacademy.IDEs.core.CrudController;
import br.com.tiacademy.IDEs.domain.IDEs;
import br.com.tiacademy.IDEs.repository.IDEsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/IDEs")
public class IDEsController extends CrudController<IDEs,IDEsDTO, Long> {

    public IDEsRepository getRepository() {
        return (IDEsRepository) repository;
    }

    @GetMapping
    public ResponseEntity<List<IDEsDTO>> listaDto() {
        var ides = getRepository().findAll();

        var idesDto = ides.stream()
                .map(idEs -> new IDEsDTO(idEs.getId(),
                idEs.getNome(),
                idEs.getLinguagem(),
                idEs.getEmpresa(),
                idEs.getLinguagem_id().stream().map(linguagem -> new LinguagemDTO(linguagem.getId(),
                        linguagem.getLinguagem(),
                        linguagem.getUso())).collect(Collectors.toList())
        )).collect(Collectors.toList());
        return ResponseEntity.ok(idesDto);
    }

    @GetMapping("/Eclipse")
    public IDEs ideEclip(){return this.getRepository().consultarPeloNome("Eclipse");}

    @GetMapping("/Intellj")
    public IDEs ideIntell(){return this.getRepository().findByNome("Intell");}

    @GetMapping("/Qnative")
    public List<IDEs> qNative(){
        return this.getRepository().findAllNative();
    }

}
