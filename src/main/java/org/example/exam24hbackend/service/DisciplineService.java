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

    // Get all disciplines
    public List<DisciplineDTO> getAllDisciplines() {
        return disciplineRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert entity to DTO
    private DisciplineDTO convertToDTO(Discipline discipline) {
        DisciplineDTO dto = new DisciplineDTO();
        dto.setId(discipline.getId());
        dto.setName(discipline.getName());
        dto.setResultType(discipline.getResultType());
        return dto;
    }

}
