package br.com.zupacademy.dani.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
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
