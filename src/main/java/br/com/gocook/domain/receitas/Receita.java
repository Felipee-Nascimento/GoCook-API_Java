package br.com.gocook.domain.receitas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "receita")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String titulo;
    private String ingrediente;
    private Integer tempoDePreparo;
    private String modoDePreparo;
    private Integer quantidadeDePessoasServidas;
}
