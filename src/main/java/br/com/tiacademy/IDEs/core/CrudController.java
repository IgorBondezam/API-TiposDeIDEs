package br.com.tiacademy.IDEs.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public abstract class CrudController<T, ID> {

    @Autowired
    protected CrudService<T, ID> service;


    @GetMapping
    public ResponseEntity<List<T>> listar(){
        var listaEntidade = service.listar();
        return ResponseEntity.ok(listaEntidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> especifico(@PathVariable("id")ID id){

        var porId = service.porId(id);

        if(Objects.isNull(porId)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(porId);
    }

    @PostMapping
    public ResponseEntity<T> criar(@RequestBody T entidade){
        var salvo = service.criar(entidade);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> modificar(@PathVariable("id")ID id, @RequestBody T entidade){
        var mudar = service.editar(id, entidade);
        return ResponseEntity.ok(mudar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id")ID id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }



}
