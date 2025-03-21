package ds.project.terraform.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetNoteDto {

    private String text;

    @Builder
    private GetNoteDto(String text) {
        this.text = text;
    }

    public static GetNoteDto of(String text) {
        return GetNoteDto.builder()
            .text(text)
            .build();
    }
}
