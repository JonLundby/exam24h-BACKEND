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
    private int participantId;
    private int disciplineId;

    public boolean isValidResult() {
        switch (resultType.toLowerCase()) {
            case "time":
                return isValidTime(resultValue);
            case "length":
                return isValidLength(resultValue);
            default:
                return false;
        }
    }

    private boolean isValidTime(String value) {
        return value.matches("\\d{2}\\.\\d{2}\\.\\d{2}");
    }

    private boolean isValidLength(String value) {
        return value.matches("\\d{1,2}\\.\\d{2}");
    }

    public String getFormattedResult() {
        switch (resultType.toLowerCase()) {
            case "time":
                return formatTime(resultValue);
            case "length":
                return formatLength(resultValue);
            default:
                return resultValue;
        }
    }

    private String formatTime(String value) {
        String[] parts = value.split("\\.");
        return String.format("%s:%s:%s", parts[0], parts[1], parts[2]);
    }

    private String formatLength(String value) {
        return value + " meters";
    }
}
