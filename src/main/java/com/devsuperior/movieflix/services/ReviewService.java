package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    public ReviewDTO insert(ReviewDTO dto) {
        return new ReviewDTO(
                repository.save(
                        new Review(
                                dto.getText(),
                                movieRepository.getReferenceById(dto.getMovieId()),
                                authService.authenticated()
                        )
                )
        );
    }
}
