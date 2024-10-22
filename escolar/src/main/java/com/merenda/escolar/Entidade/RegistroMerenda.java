package com.merenda.escolar.Entidade;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "registro_merenda")
public class RegistroMerenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "merenda_id")
    private Merenda merenda;

    private LocalDateTime dataRegistro;
}