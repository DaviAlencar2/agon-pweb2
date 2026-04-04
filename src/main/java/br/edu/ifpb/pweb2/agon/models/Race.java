package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(nullable = true)
    private Integer timeSeconds;

    private Boolean active = false;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<Question> questions;
}
