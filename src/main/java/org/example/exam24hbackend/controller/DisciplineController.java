package org.example.exam24hbackend.controller;

import org.example.exam24hbackend.dto.DisciplineDTO;
import org.example.exam24hbackend.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/disciplines")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @GetMapping("")
    public List<DisciplineDTO> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> getDisciplineById(@PathVariable int id) {
        DisciplineDTO disciplineDTO = disciplineService.getDisciplineById(id);
        if (disciplineDTO != null) {
            return ResponseEntity.ok(disciplineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<DisciplineDTO> createDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        DisciplineDTO createdDiscipline = disciplineService.createDiscipline(disciplineDTO);
        return ResponseEntity.ok(createdDiscipline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDTO> updateDiscipline(@PathVariable int id, @RequestBody DisciplineDTO disciplineDTO) {
        DisciplineDTO updatedDiscipline = disciplineService.updateDiscipline(id, disciplineDTO);
        if (updatedDiscipline != null) {
            return ResponseEntity.ok(updatedDiscipline);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable int id) {
        boolean isDeleted = disciplineService.deleteDiscipline(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
