package com.example.filmRecommendService.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class PersonInFilm implements Serializable{
//    @Id
//    Long personId;
//    @Id
//    Long filmId;
    @NotNull
    private PersonRole role;

    @ManyToOne
    @JoinColumn(name = "person_id_in_film", referencedColumnName = "id")
    @Id
    @MapsId
    private Person person;

    @ManyToOne
    @JoinColumn(name = "film_id",referencedColumnName = "id")
    @Id
    @MapsId
    private Film film;

}
