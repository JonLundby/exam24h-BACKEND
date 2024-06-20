package org.example.exam24hbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultDTO {
    private int id;
    private String resultType;
    private String resultValue;
    private String participantName;
    private String disciplineName;

}
