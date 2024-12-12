package br.com.alura.challenge_literalura.repository;

import br.com.alura.challenge_literalura.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
    Optional<Idioma> findBySiglaIdioma(String siglaIdioma);
}

