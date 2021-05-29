package br.com.zupacademy.dani.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarCategoria(@RequestBody @Valid CategoriaRequest request) {
        Categoria novaCategoria = request.toModel();
        manager.persist(novaCategoria);
        return ResponseEntity.ok(new CategoriaResponse(novaCategoria));
    }

}
