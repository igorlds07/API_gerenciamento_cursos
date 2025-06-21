package com.APICursos.demo.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CursoRequestDTO {


    @NotBlank(message = "O nome do curso é obrigatório!")
    @Size(max = 255, message = "O nome do curso deve ter no máximo 255 caracteres!")
    private String nameCurso;


    @NotBlank(message = "A categoria do curso é obrigatória!")
    @Size(max = 255, message = "A categoria do curso deve ter no máximo 255 caracteres")
    private String categoryCurso;

}
