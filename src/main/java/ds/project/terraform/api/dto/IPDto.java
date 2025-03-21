package ds.project.terraform.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class IPDto {

    private String ip;

    @Builder
    private IPDto(String ip) {
        this.ip = ip;
    }

    public static IPDto of(String ip) {
        return IPDto.builder().ip(ip).build();
    }
}
