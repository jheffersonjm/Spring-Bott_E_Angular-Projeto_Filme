package br.com.jhefferson.filmes.repositorio;

import br.com.jhefferson.filmes.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
