package br.com.alura.challenge_literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "idiomas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String siglaIdioma;

    @ManyToMany(mappedBy = "idioma")
    private List<Livro> livros;

    public Idioma() {
    }

    public Idioma(String siglaIdioma){
        this.siglaIdioma = siglaIdioma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getSiglaIdioma() {
        return siglaIdioma;
    }

    public void setSiglaIdioma(String siglaIdioma) {
        this.siglaIdioma = siglaIdioma;
    }
}
