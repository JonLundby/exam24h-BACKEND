package org.example.exam24hbackend.service;

import org.example.exam24hbackend.dto.ResultDTO;
import org.example.exam24hbackend.entity.Result;
import org.example.exam24hbackend.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    //******* GET ALL RESULTS *******\\
    public List<ResultDTO> getAllResults() {
        return resultRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //******* CREATE NEW RESULT *******\\
    public Result createNewResult(Result request) {
        if (request.getResult_id() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide an id for a new result");
        }

        return resultRepository.save(request);
    }

    //******* DELETE RESULT *******\\
    public ResponseEntity deleteResult(int id) {
        Result resultToDelete = resultRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "cant delete, id does not exist"));
        resultRepository.delete(resultToDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ResultDTO convertToDTO(Result result) {
        ResultDTO dto = new ResultDTO();
        dto.setId(result.getResult_id());
        dto.setResultType(result.getResultType());
        dto.setResultValue(result.getResultValue());
        dto.setParticipantName(result.getParticipant().getName());
        dto.setDisciplineName(result.getDiscipline().getName());
        return dto;
    }

}
