package com.APICursos.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Data
@Entity(name = "Curso")
@Table(name = "Cursos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_curso")
    private UUID idCurso;

    @Column(name = "name_curso")
    private String nameCurso;

    @Column(name = "category_curso")
    private String category;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusCurso status = StatusCurso.ATIVO;

    private LocalDateTime dataCreated;

    private LocalDateTime updateDate;

    public enum StatusCurso{
        ATIVO,
        INATIVO
    }

}
