package br.com.tiacademy.IDEs.controller;

import br.com.tiacademy.IDEs.core.CrudController;
import br.com.tiacademy.IDEs.domain.IDEs;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/IDEs")
public class IDEsController extends CrudController<IDEs, Long> {

}
