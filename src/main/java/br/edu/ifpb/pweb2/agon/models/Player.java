package br.edu.ifpb.pweb2.agon.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Boolean admin;

    @ManyToMany
    private List<Race> completedRaces;

}
