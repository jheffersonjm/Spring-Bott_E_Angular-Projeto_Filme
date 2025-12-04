package br.com.jhefferson.filmes.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhefferson.filmes.model.Usuario;

public interface Usuariorepository extends JpaRepository<Usuario, Long> {



    

  
}
