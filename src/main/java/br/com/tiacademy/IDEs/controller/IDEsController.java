package br.com.tiacademy.IDEs.controller;

import br.com.tiacademy.IDEs.DTO.IDEsDTO;
import br.com.tiacademy.IDEs.DTO.LinguagemDTO;
import br.com.tiacademy.IDEs.core.CrudController;
import br.com.tiacademy.IDEs.core.CrudConverter;
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


    //Lista findAll convertido para DTO
    @GetMapping
    public ResponseEntity<List<IDEsDTO>> listaDto() {
        var ides = getRepository().findAll();

        var idesDto = ides.stream()
                .map(idEs -> new IDEsDTO(idEs.getId(),
                idEs.getNome(),
                idEs.getLinguagem(),
                idEs.getEmpresa(),
                idEs.getIdLinguagem().stream().map(linguagem -> new LinguagemDTO(linguagem.getId(),
                        linguagem.getLinguagem(),
                        linguagem.getUso())).collect(Collectors.toList())
        )).collect(Collectors.toList());
        return ResponseEntity.ok(idesDto);
    }

    //@Query(value = "select i from IDEs i where i.nome = :nome")
    @GetMapping("/Eclipse")
    public List<IDEsDTO> ideEclip(){
        var listQides = this.getRepository().consultarPeloNome("Eclipse");

        var idesDto = listQides.stream()
                .map(idEs -> new IDEsDTO(idEs.getId(),
                        idEs.getNome(),
                        idEs.getLinguagem(),
                        idEs.getEmpresa(),
                        idEs.getIdLinguagem().stream().map(linguagem -> new LinguagemDTO(linguagem.getId(),
                                linguagem.getLinguagem(),
                                linguagem.getUso())).collect(Collectors.toList())
                )).collect(Collectors.toList());
        return idesDto;
    }


    //List<IDEs> findByNome(String nome);
    @GetMapping("/Intellj")
    public List<IDEsDTO> ideIntell(){
        var listQides = this.getRepository().findByNome("Intellj");

        var idesDto = listQides.stream()
                .map(idEs -> new IDEsDTO(idEs.getId(),
                        idEs.getNome(),
                        idEs.getLinguagem(),
                        idEs.getEmpresa(),
                        idEs.getIdLinguagem().stream().map(linguagem -> new LinguagemDTO(linguagem.getId(),
                                linguagem.getLinguagem(),
                                linguagem.getUso())).collect(Collectors.toList())
                )).collect(Collectors.toList());
        return idesDto;
    }


    //@Query(value = "select * from ides i order by linguagem asc", nativeQuery = true)
    @GetMapping("/Qnative")
    public List<IDEsDTO> qNative(){
        var listQides= this.getRepository().findAllNative();

        var idesDto = listQides.stream()
                .map(idEs -> new IDEsDTO(idEs.getId(),
                        idEs.getNome(),
                        idEs.getLinguagem(),
                        idEs.getEmpresa(),
                        idEs.getIdLinguagem().stream().map(linguagem -> new LinguagemDTO(linguagem.getId(),
                                linguagem.getLinguagem(),
                                linguagem.getUso())).collect(Collectors.toList())
                )).collect(Collectors.toList());
        return idesDto;

    }

}
