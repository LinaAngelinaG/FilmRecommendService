package com.example.filmRecommendService.repository;

import com.example.filmRecommendService.model.entity.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Long> {
    Optional<Film> findAllByFilmName(String filmName);
}
