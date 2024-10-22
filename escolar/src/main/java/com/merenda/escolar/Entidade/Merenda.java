package com.merenda.escolar.Entidade;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "merenda")
public class Merenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String diaSemana;
}
