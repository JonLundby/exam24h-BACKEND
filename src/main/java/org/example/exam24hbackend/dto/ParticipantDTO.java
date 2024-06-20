package org.example.exam24hbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.exam24hbackend.entity.Discipline;
import org.example.exam24hbackend.entity.Result;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ParticipantDTO {
    private Integer id;
    private String name;
    private int age;
    private String gender;
    private String club;
    private Set<Result> results;
    private Set<Discipline> disciplines;
}
