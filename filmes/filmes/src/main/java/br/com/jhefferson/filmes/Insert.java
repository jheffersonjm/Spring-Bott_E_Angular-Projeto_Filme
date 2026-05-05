package br.com.jhefferson.filmes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.jhefferson.filmes.model.Avaliacao;
import br.com.jhefferson.filmes.model.Genero;
import br.com.jhefferson.filmes.model.Obra;
import br.com.jhefferson.filmes.model.Usuario;
import br.com.jhefferson.filmes.repositorio.AvaliacaoRepository;
import br.com.jhefferson.filmes.repositorio.GeneroRepository;
import br.com.jhefferson.filmes.repositorio.ObraRepository;
import br.com.jhefferson.filmes.repositorio.Usuariorepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jhefferson.7980
 */
@Component
public class Insert implements CommandLineRunner{

   
    @Autowired
    private ObraRepository obraRepository;
    
    @Autowired
    private GeneroRepository generoRepository;
    
    @Autowired
    Usuariorepository usuarioRepository;
    
    @Autowired
    AvaliacaoRepository avaliacaoRepository;
    

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario(
            null, 
            "Jhefferson", 
            "Jhefferson@gmail.com", 
            "123456"
        );
        Genero genero= new Genero( 
            null, 
            "aventura"
        ); 
        generoRepository.save(genero);

        Genero genero2= new Genero(
            null, 
            "Terror"
        );

        Genero genero3 = new Genero(
            null, 
            "Comedia"
        );

        List<Genero> generos = Arrays.asList(genero, genero2, genero3);
        generoRepository.saveAll(generos); //
             Obra obra1= new Obra(
            null,
            "Esqueserão de mim",
            "um menino e esquesido em casa no natal e precisa defender a casa de ladrões",
            1990,
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.adorocinema.com%2Ffilmes%2Ffilme-6272%2F&psig=AOvVaw2toHFLEx4lYeROHCJD2uGh&ust=1761432862299000&source=images&cd=vfe&opi=89978449&ved=0CBUQjRxqFwoTCPD1xvH2vZADFQAAAAAdAAAAABAE", 
            "aventura infaltiu" 
            , genero
        );

    obraRepository.save(obra1);


        usuarioRepository.save(usuario);

        Avaliacao avaliacao = new Avaliacao(
            null,
            "10", // nota
            "ele é um filme para aselerar a o coração", // comentario
            LocalDateTime.now(), // data
            usuario, // usuario
            obra1 // obra
        );
        
        avaliacaoRepository.save(avaliacao);
   }
}
