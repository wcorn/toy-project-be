package ds.project.terraform.api.dto;

import lombok.Getter;

@Getter
public class IntroduceDto {
    private String text;

    public IntroduceDto(String text) {
        this.text = text;
    }
}
