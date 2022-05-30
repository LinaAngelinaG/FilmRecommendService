package com.example.filmRecommendService.model.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
public class UsersRateForFilm implements Serializable {
//    @Id
//    @Column(name = "id_of_user_rated_this_film",nullable = false)
//    private Long userId;
//
//    @Id
//    @Column(name = "id_of_rated_film",nullable = false)
//    private Long filmId;

    @Min(1)
    @Max(10)
    @Column(name = "rate_from_user")
    private int rateFromUser;

    @ManyToOne
    @Id
    @MapsId
    @JoinColumn(name = "id_of_rated_film",referencedColumnName="id",nullable = false)
    private User user;

    @ManyToOne
    @MapsId
    @Id
    @JoinColumn(name = "id_of_user_rated_this_film",referencedColumnName="id",nullable = false)
    private Film film;
}
