package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer timeSeconds;
    private Boolean active = true;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<Question> questions;
}
