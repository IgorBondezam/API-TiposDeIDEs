package br.com.tiacademy.IDEs.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public abstract class CrudController<T extends CrudDomain<ID>, D, ID> {

    @Autowired(required = false)
    protected CrudConverter<T, D> converter;

    @Autowired
    protected CrudRepository<T, ID> repository;

    @Autowired
    protected CrudService<T, ID> service;


    @GetMapping("/loop")
    public ResponseEntity<List<T>> listar(){
        var listaEntidade = service.listar();
        return ResponseEntity.ok(listaEntidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> especifico(@PathVariable("id")ID id){

        var porId = service.porId(id);

        if(Objects.isNull(porId)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(converter.entidadeParaDTO(porId));
    }

    @PostMapping
    public ResponseEntity<D> criar(@RequestBody D dto){

        var entidade = converter.dtoParaEntidade(dto);
        var salvo = service.criar(entidade);
        return ResponseEntity.ok(converter.entidadeParaDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> modificar(@PathVariable("id")ID id, @RequestBody D dto){
        var novaEntidade = converter.dtoParaEntidade(dto);
        var mudar = service.editar(id,novaEntidade);
        return ResponseEntity.ok(converter.entidadeParaDTO(mudar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id")ID id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }



}
