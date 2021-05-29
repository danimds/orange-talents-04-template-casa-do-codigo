package br.com.zupacademy.dani.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/autores")
    public ResponseEntity cadastraAutor(@RequestBody @Valid AutorRequest request) {
        Optional<Autor> resultadoEmailDuplicado = autorRepository.findByEmail(request.getEmail());
        if (resultadoEmailDuplicado.isPresent()) {
            return ResponseEntity.status(422).body("Email já existe no sistema");
        }
        Autor autor = request.ToModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }

}
