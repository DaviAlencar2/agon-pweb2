package br.edu.ifpb.pweb2.agon.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceDto {
    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 200)
    private String description;

}
