package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=100)
    private String title;

    @NotBlank
    @Size(max=100)
    private String description;

    @NotNull
    @Max(600)
    private Integer timeSeconds;

    private Boolean active = true;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<Question> questions;
}
