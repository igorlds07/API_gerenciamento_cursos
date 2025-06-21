package com.APICursos.demo.Repository;

import com.APICursos.demo.Entity.CursosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CursoRepository extends JpaRepository<CursosEntity, UUID> {

    Optional<CursosEntity> findByNameCurso(String nameCurso);

    Optional<CursosEntity> findByIdCurso(UUID idCurso);

    List<CursosEntity> findByNameCursoContainingIgnoreCase(String nameCurso);

    List<CursosEntity> findByCategoryContainingIgnoreCase(String category);

    List<CursosEntity> findByNameCursoContainingIgnoreCaseAndCategoryContainingIgnoreCase(String nameCurso, String category);

    List<CursosEntity> findByNameCursoOrCategory(String nameCurso, String category);
}
