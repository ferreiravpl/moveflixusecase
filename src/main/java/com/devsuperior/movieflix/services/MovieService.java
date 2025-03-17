package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public MovieDetailsDTO findById(Long id) {
        return repository.findById(id)
                .map(MovieDetailsDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    public Page<MovieDetailsDTO> findByGenre(String idGenre, Pageable pageable) {
        Long genreIdLong = null;

        if(nonNull(idGenre)) {
            genreIdLong = Long.parseLong(idGenre);
        }

        return repository.findByGenre(genreIdLong, pageable);

    }
}
