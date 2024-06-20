package org.example.exam24hbackend.service;

import org.example.exam24hbackend.dto.ParticipantDTO;
import org.example.exam24hbackend.entity.Participant;
import org.example.exam24hbackend.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    //******* GET ALL PARTICIPANTS *******\\
    public List<ParticipantDTO> getAllParticipants() {
        return participantRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //******* GET SPECIFIC/ID PARTICIPANT *******\\
    public ParticipantDTO getParticipantById(int id) {
        Participant participant = participantRepository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found"));
        return convertToDTO(participant);
    }

    //******* CREATE PARTICIPANT *******\\
    public Participant createParticipant(Participant request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the participant id!");
        }

        return participantRepository.save(request);
    }

    //******* UPDATE PARTICIPANT *******\\
    public ParticipantDTO updateParticipant(int id, ParticipantDTO participantToUpdate) {
        if (participantToUpdate.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is permanent and cant be changed");
        }
        Participant participant = participantRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Participant not found"));
        participant.setName(participantToUpdate.getName());
        participant.setAge(participantToUpdate.getAge());
        participant.setGender(participantToUpdate.getGender());
        participant.setClub(participantToUpdate.getClub());
        participantRepository.save(participant);
        return convertToDTO(participant);
    }

    //******* DELETE PARTICIPANT *******\\
    public ResponseEntity deleteParticipant(int id) {
        Participant participantToDelete = participantRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Participant not found!"));
        participantRepository.delete(participantToDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ParticipantDTO convertToDTO(Participant participant) {
        ParticipantDTO dto = new ParticipantDTO();
        dto.setId(participant.getId());
        dto.setName(participant.getName());
        dto.setAge(participant.getAge());
        dto.setGender(participant.getGender());
        dto.setClub(participant.getClub());
        return dto;
    }

    private Participant convertToEntity(ParticipantDTO dto) {
        Participant participant = new Participant();
        participant.setId(dto.getId());
        participant.setName(dto.getName());
        participant.setAge(dto.getAge());
        participant.setGender(dto.getGender());
        participant.setClub(dto.getClub());
        return participant;
    }
}
