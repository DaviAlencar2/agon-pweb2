package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=50)
    @Getter
    @Setter
    private String name;

    private String email;

    private Boolean admin = false;

    @ManyToMany
    private List<Race> completedRaces;

}
