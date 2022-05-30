package com.example.filmRecommendService.model.entity;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private Date dateOfCreating;

    @NotBlank
    @NotNull
    private String filmName;
    private String description = null;

    @Min(1)
    @Max(10)
    private Double filmRating = null;

    @OneToMany(mappedBy = "film")
    private Set<UsersRateForFilm> usersRateForFilm;

    @OneToMany(mappedBy = "film")
    private Set<PersonInFilm> personInFilm;
}
