package br.com.zupacademy.dani.casadocodigo.categoria;

public class CategoriaResponse {

    private Long id;
    private String nome;

    public CategoriaResponse(Categoria novaCategoria) {
        this.id= novaCategoria.getId();
        this.nome = novaCategoria.getNome();
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
