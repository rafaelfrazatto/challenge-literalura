package br.com.alura.challenge_literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(name = "ano_nascimento")
    private Integer anoNascimento;

    @Column(name = "ano_falecimento")
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Livro> livros;

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        if (livros != null) {
            livros.forEach(b -> {
                if (b.getAutor() == null) {
                    b.setAutor(this);
                }
            });
        }
        this.livros = livros;
    }

    @Override
    public String toString() {
        return  "\nAutor: " + nome + "\n" +
                "Ano de nascimento: " + anoNascimento + "\n" +
                "Ano de falecimento: " + anoFalecimento + "\n" +
                "Livros: " + formatarLivros(livros);
    }

    private String formatarLivros(List<Livro> livros) {
        if (livros == null || livros.isEmpty()) {
            return "Nenhum livro registrado.";
        }
        return livros.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.joining(" | "));
    }

}
