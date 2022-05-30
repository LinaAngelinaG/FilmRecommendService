package com.example.filmRecommendService.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private Gender gender;

    @NotBlank
    @Size(min = 10)
    @Column(nullable = false)
    private String password;

    @Email(message = "Error! Email is invalid!")
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<UsersRateForFilm> usersRateForFilm;

}
