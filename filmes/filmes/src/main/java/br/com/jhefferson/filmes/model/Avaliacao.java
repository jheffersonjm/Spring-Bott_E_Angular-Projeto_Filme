package br.com.jhefferson.filmes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Avaliaçao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue
    private Long id;
    // coloca o nome;
    // não deixa ser null grasas a o nullable = false;
    @Column(name = "Nota", nullable = false)
    private String nota;
    private String comentario;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "obra_id", referencedColumnName = "id")
    private Obra obra;

}
