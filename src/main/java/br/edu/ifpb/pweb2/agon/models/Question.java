package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statement;

    @ElementCollection
    private List<String> options;

    private Integer anwser;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
}
