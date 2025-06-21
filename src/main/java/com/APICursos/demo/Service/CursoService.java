package com.APICursos.demo.Service;


import com.APICursos.demo.DTO.CursoRequestDTO;
import com.APICursos.demo.DTO.CursoResponseDTO;
import com.APICursos.demo.Repository.CursoRepository;
import com.APICursos.demo.Entity.CursosEntity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    public CursoResponseDTO createdCurso( CursoRequestDTO dto) {
        if (dto.getNameCurso() == null || dto.getNameCurso().isBlank()){
            throw new IllegalArgumentException("O nome não pode estar vazio!");
        }
        CursosEntity newCurso = CursosEntity.builder()
                .nameCurso(dto.getNameCurso().trim())
                .category(dto.getCategoryCurso())
                .status(CursosEntity.StatusCurso.ATIVO)
                .dataCreated(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        return CursoResponseDTO.toResponseDTO(cursoRepository.save(newCurso));
    }

    public List<CursoResponseDTO> listAllCursos(String name, String category) {
        List<CursosEntity> cursos = List.of();

        if ((name == null || name.isBlank()) && (category == null || category.isBlank())) {
            cursos = cursoRepository.findAll();

        } else if (name != null && category != null) {
            cursos = cursoRepository.findByNameCursoContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                    name.trim().toLowerCase(), category.trim().toLowerCase()
            );
        } else if (name != null) {
            cursos = cursoRepository.findByNameCursoContainingIgnoreCase(name);
        } else if (category != null) {
            cursos = cursoRepository.findByCategoryContainingIgnoreCase(category);

        }
        return cursos
                .stream()
                .map(CursoResponseDTO::toResponseDTO)
                .toList();

    }
    public CursoResponseDTO updateCurso(String idCurso, CursoRequestDTO dto) {
        if (idCurso == null || idCurso.isBlank()) {
            throw new RuntimeException("O Id não pode ser vazio!");
        }
        UUID uuidCurso = UUID.fromString(idCurso);

        CursosEntity updateCurso = cursoRepository.findByIdCurso(uuidCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        updateCurso.setNameCurso(dto.getNameCurso());
        updateCurso.setCategory(dto.getCategoryCurso());
        updateCurso.setUpdateDate(LocalDateTime.now());

        cursoRepository.save(updateCurso);

        return CursoResponseDTO.toResponseDTO(updateCurso);
    }

    public void deleteCurso(String idCurso){
        if (idCurso == null || idCurso.isBlank()){
            throw new IllegalArgumentException("O Id não pode estar vazio");
        }
        UUID uuidCurso = UUID.fromString(idCurso);

        CursosEntity idCursoDelete = cursoRepository.findByIdCurso(uuidCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        cursoRepository.delete(idCursoDelete);

    }

    public String updateStatus(String idCurso){
        if (idCurso == null || idCurso.isBlank()){
            throw new RuntimeException("O Id não pode ser vazio");
        }
        UUID uuidCurso = UUID.fromString(idCurso);

        CursosEntity uuidStatusForUpdate = cursoRepository.findByIdCurso(uuidCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (uuidStatusForUpdate.getStatus() ==  CursosEntity.StatusCurso.ATIVO) {
            uuidStatusForUpdate.setStatus(CursosEntity.StatusCurso.INATIVO);

        }else {
            uuidStatusForUpdate.setStatus(CursosEntity.StatusCurso.ATIVO);

        }
        uuidStatusForUpdate.setUpdateDate(LocalDateTime.now());

        cursoRepository.save(uuidStatusForUpdate);

        return "Status do curso "
                + uuidStatusForUpdate.getNameCurso()
                + " , atualizado para " +uuidStatusForUpdate.getStatus();
    }

}
