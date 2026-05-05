package br.com.jhefferson.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class FilmesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmesApplication.class, args);
        
    }

}
