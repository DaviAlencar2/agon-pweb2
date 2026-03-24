package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String timeSeconds;
    private Boolean active = true;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<Question> questions;
}
