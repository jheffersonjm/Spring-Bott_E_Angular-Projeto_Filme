package br.com.jhefferson.filmes.model;

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
@Table(name = "Obra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String descrition;
    private Integer anoLancamento;
    private String imagemUrl;
    private String tipoObra;
    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName= "id")
    private Genero genero;
   

}
