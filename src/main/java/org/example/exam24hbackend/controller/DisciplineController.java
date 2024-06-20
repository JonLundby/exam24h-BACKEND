package org.example.exam24hbackend.controller;

import org.example.exam24hbackend.dto.DisciplineDTO;
import org.example.exam24hbackend.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
