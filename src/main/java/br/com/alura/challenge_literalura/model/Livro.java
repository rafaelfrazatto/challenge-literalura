package br.com.alura.challenge_literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Autor autor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "livro_idiomas",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id"))
    private List<Idioma> idioma;

    private Integer downloads;

    public Livro() {}

    public Livro(String titulo, Autor autor, List<Idioma> idioma, Integer downloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Idioma> getIdiomas() {
        return idioma;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idioma = idiomas;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "\n---------- LIVRO ----------" + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + formatarAutor(autor) + "\n" +
                "Idioma: " + formatarIdiomas(idioma) + "\n" +
                "Downloads: " + downloads + "\n" +
                "---------------------------";
    }

    private String formatarAutor(Autor autor) {
        if (autor == null) {
            return "Autor desconhecido";
        }
        return autor.getNome();
    }

    private String formatarIdiomas(List<Idioma> idiomas) {
        if (idiomas == null || idiomas.isEmpty()) {
            return "Idioma desconhecido";
        }
        return idiomas.stream()
                .map(Idioma::getSiglaIdioma)
                .collect(Collectors.joining(", "));
    }


}
