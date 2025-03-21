package ds.project.terraform.api.dto;

import lombok.Getter;

@Getter
public class TimeDto {
    String time;

    public TimeDto(String time) {
        this.time = time;
    }
}
