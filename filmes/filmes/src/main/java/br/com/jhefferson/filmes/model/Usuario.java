/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jhefferson.filmes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jhefferson.7980
 */
@Entity

// para perdonalisar o nome da tabela.
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    // criando um id usando as anotação abaixo @id e a @GeneratedValue
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    // se querer personalisar a coluna.
    // ele vai crira uma coluna com o nome nome, com tamanho 2000 e nao pode ser nulo
    @Column(name = "nome", length = 2000, nullable = false)
    private String nome;

    // ele vai crira uma coluna com o nome Gmail
    @Column(name = "Gmail")
    private String gmail;
    // ele vai crira uma coluna com o nome Senha
    @Column(name = "sennha")
    private String senha;

    // aqui e a modelagem da tabela usuario.
    // a tabela usuario tem os seguintes campos:
    // id: identificador único do usuário (chave primária)
    // nome: nome do usuário
    // Gmail: email do usuário
    // Senha: senha do usuário

}
