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

    // Convert entity to DTO
    private DisciplineDTO convertToDTO(Discipline discipline) {
        DisciplineDTO dto = new DisciplineDTO();
        dto.setId(discipline.getId());
        dto.setName(discipline.getName());
        dto.setResultType(discipline.getResultType());
        return dto;
    }

    // Convert DTO to entity
    private Discipline convertToEntity(DisciplineDTO dto) {
        Discipline discipline = new Discipline();
        discipline.setId(dto.getId());
        discipline.setName(dto.getName());
        discipline.setResultType(dto.getResultType());
        return discipline;
    }

    // Create a new discipline
    public DisciplineDTO createDiscipline(DisciplineDTO disciplineDTO) {
        Discipline discipline = convertToEntity(disciplineDTO);
        discipline = disciplineRepository.save(discipline);
        return convertToDTO(discipline);
    }

    // Get all disciplines
    public List<DisciplineDTO> getAllDisciplines() {
        return disciplineRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a discipline by id
    public DisciplineDTO getDisciplineById(int id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        return discipline.map(this::convertToDTO).orElse(null);
    }

    // Update a discipline
    public DisciplineDTO updateDiscipline(int id, DisciplineDTO disciplineDTO) {
        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(id);
        if (optionalDiscipline.isPresent()) {
            Discipline discipline = optionalDiscipline.get();
            discipline.setName(disciplineDTO.getName());
            discipline.setResultType(disciplineDTO.getResultType());
            discipline = disciplineRepository.save(discipline);
            return convertToDTO(discipline);
        } else {
            return null;
        }
    }

    // Delete a discipline
    public boolean deleteDiscipline(int id) {
        if (disciplineRepository.existsById(id)) {
            disciplineRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
