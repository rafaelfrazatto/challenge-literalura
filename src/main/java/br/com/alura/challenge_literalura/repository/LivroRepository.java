package br.com.alura.challenge_literalura.repository;

import br.com.alura.challenge_literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByIdioma_SiglaIdiomaOrderByAutor_NomeAsc(String idiomaEscolhido);

    List<Livro> findTop10ByOrderByDownloadsDesc();

    List<Livro> findByAutor_NomeContainingIgnoreCase(String autorEscolhido);
}
