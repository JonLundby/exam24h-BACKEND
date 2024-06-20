package org.example.exam24hbackend.controller;

import org.example.exam24hbackend.dto.ResultDTO;
import org.example.exam24hbackend.entity.Result;
import org.example.exam24hbackend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/results")
public class ResultController {

    @Autowired
    ResultService resultService;

    //******* GET ALL RESULTS *******\\
    @GetMapping("")
    public List<ResultDTO> getAllResults() {
        return resultService.getAllResults();
    }

    //******* CREATE NEW RESULTS *******\\
    @PostMapping("")
    public Result createNewResult(@RequestBody Result request) {
        resultService.createNewResult(request);
        return request;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteResult(@PathVariable int id) {
        return resultService.deleteResult(id);
    }
}
