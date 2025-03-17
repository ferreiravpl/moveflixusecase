package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT new com.devsuperior.movieflix.dto.MovieDetailsDTO(m) " +
            "FROM Movie m " +
            "WHERE (:idGenre IS NULL OR m.genre.id = :idGenre) " +
            "ORDER BY m.title ASC")
    Page<MovieDetailsDTO> findByGenre(@Param("idGenre") Long idGenre, Pageable pageable);
}
