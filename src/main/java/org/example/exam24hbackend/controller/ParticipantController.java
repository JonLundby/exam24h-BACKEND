package org.example.exam24hbackend.controller;

import org.example.exam24hbackend.dto.ParticipantDTO;
import org.example.exam24hbackend.entity.Participant;
import org.example.exam24hbackend.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/participants")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    //******* GET ALL PARTICIPANTS *******\\
    @GetMapping("")
    public List<ParticipantDTO> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    //******* GET SPECIFIC/ID PARTICIPANTS *******\\
    @GetMapping("/{id}")
    public ParticipantDTO getParticipantById(@PathVariable int id) {
        return participantService.getParticipantById(id);
    }

    //******* CREATE PARTICIPANT *******\\
    @PostMapping("")
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant request) {
        Participant newParticipant = participantService.createParticipant(request);
        return new ResponseEntity<>(newParticipant, HttpStatus.CREATED);
    }

    //******* UPDATE PARTICIPANT *******\\
    @PutMapping("{id}")
    public ParticipantDTO updateParticipant(@PathVariable int id, @RequestBody ParticipantDTO participantToUpdate) {
        return participantService.updateParticipant(id, participantToUpdate);
    }

    //******* DELETE PARTICIPANT *******\\
    @DeleteMapping("/{id}")
    public ResponseEntity deleteParticipant(@PathVariable int id) {
        return participantService.deleteParticipant(id);
    }

}
