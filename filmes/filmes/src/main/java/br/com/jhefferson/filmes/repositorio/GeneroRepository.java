package br.com.jhefferson.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhefferson.filmes.model.Genero;

public interface GeneroRepository extends JpaRepository <Genero, Long> {
}
