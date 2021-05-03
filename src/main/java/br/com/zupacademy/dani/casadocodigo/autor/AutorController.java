package br.com.zupacademy.dani.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/autores")
    public void cadastraAutor(@RequestBody @Valid AutorRequest request) {
        Autor autor =  request.converter();
        autorRepository.save(autor);
    }
}
