package br.edu.ifpb.pweb2.agon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {

    private String name;

    private String email;

    private Boolean admin = false;
}
