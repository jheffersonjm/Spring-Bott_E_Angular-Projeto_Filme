/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.jhefferson.filmes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author villaca
 */
@Component
public class CorsFilter implements WebMvcConfigurer {
 // ele que vai configurar o cors para liberar o acesso do angular para o spring boot
    @Bean
    // método que retorna um WebMvcConfigurer
    public WebMvcConfigurer corsConfigurer() {
        // retorna uma nova instância de WebMvcConfigurer
        return new WebMvcConfigurer() {
            // sobrescreve o método addCorsMappings para configurar o CORS
            public void addCorsMappings(CorsRegistry registry) {
                // adiciona um mapeamento CORS para todas as rotas (/**)
                registry.addMapping("/**")
                // configura as origens permitidas
                        .allowedOrigins("http://localhost:4200", "http://localhost:4300")
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

}