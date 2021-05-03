package br.com.zupacademy.dani.casadocodigo.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime criadoEm = LocalDateTime.now(ZoneOffset.UTC);

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
