package br.com.jhefferson.filmes.repositorio;

import br.com.jhefferson.filmes.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository <Avaliacao, Long> {
}
