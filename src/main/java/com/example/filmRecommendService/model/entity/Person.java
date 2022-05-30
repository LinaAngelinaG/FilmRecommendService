package com.example.filmRecommendService.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @NotNull
    private String fullName;

    @OneToMany(mappedBy = "person")
    private Set<PersonInFilm> personInFilms;
}
