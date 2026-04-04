package br.edu.ifpb.pweb2.agon.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {

    @NotBlank
    @Size(max=50)
    private String name;

    private String email;

    private Boolean admin = false;
}
