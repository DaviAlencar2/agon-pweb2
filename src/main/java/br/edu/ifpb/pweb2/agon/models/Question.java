package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statement;

    @ElementCollection
    private List<String> options;

    private Integer answer;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
}
