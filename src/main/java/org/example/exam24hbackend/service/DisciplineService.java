package org.example.exam24hbackend.service;

import org.example.exam24hbackend.dto.DisciplineDTO;
import org.example.exam24hbackend.entity.Discipline;
import org.example.exam24hbackend.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    //******* Get all disciplines *******\\
    public List<DisciplineDTO> getAllDisciplines() {
        return disciplineRepository.findAll()
                .stream()
                .map(this::convertToDisciplineDTO)
                .collect(Collectors.toList());
    }

    //******* Convert entity to DTO *******\\
    public DisciplineDTO convertToDisciplineDTO(Discipline discipline) {
        DisciplineDTO dto = new DisciplineDTO();
        dto.setId(discipline.getId());
        dto.setResultType(discipline.getResultType());
        dto.setName(discipline.getName());

        return dto;
    }

    //******* Convert DTO to entity *******\\
    public Discipline convertDisciplineDTOEntity(DisciplineDTO dto) {
        Discipline discipline = new Discipline();
        discipline.setId(dto.getId());
        discipline.setName(dto.getName());
        discipline.setResultType(dto.getResultType());
        return discipline;
    }
    
}
