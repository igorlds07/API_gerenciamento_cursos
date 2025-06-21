package com.APICursos.demo.Controller;

import com.APICursos.demo.DTO.CursoRequestDTO;
import com.APICursos.demo.DTO.CursoResponseDTO;
import com.APICursos.demo.Entity.CursosEntity;
import com.APICursos.demo.Repository.CursoRepository;
import com.APICursos.demo.Service.CursoService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<CursoResponseDTO> createCurso(@RequestBody @Valid CursoRequestDTO dto){
        CursoResponseDTO responseDTO = cursoService.createdCurso(dto);
        return ResponseEntity.ok(responseDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> updateCurso( @PathVariable String id , @RequestBody CursoRequestDTO dto){
        CursoResponseDTO update = cursoService.updateCurso(id, dto);
        return ResponseEntity.ok(update);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listAllCurso(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category ){

        List<CursoResponseDTO> response = cursoService.listAllCursos(name, category);

        return ResponseEntity.ok(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable String id){
        cursoService.deleteCurso(id);
        return ResponseEntity.ok("Curso deletado com sucesso!");
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<String> updateStatus(@PathVariable String id){
        String message = cursoService.updateStatus(id);
        return ResponseEntity.ok(message);
    }

}
