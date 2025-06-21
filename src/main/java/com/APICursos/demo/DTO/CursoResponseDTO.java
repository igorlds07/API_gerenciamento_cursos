package com.APICursos.demo.DTO;

import com.APICursos.demo.Entity.CursosEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDTO {

    private UUID id;
    private String name;
    private String category;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCreated;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updateDate;


    public static CursoResponseDTO toResponseDTO(CursosEntity curso) {
        return new CursoResponseDTO(
                curso.getIdCurso(),
                curso.getNameCurso(),
                curso.getCategory(),
                curso.getStatus().toString(),
                curso.getDataCreated(),
                curso.getUpdateDate() != null ? curso.getUpdateDate() : curso.getDataCreated()
        );
    }
}
