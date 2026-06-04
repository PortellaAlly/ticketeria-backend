package com.example.ticket.ticketeria_back_end.controller;

import com.example.ticket.ticketeria_back_end.database.model.MovieEntity;
import com.example.ticket.ticketeria_back_end.dto.MovieDto;
import com.example.ticket.ticketeria_back_end.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mvinfo")
@RequiredArgsConstructor
public class MovieInfoController {

    private final MoviesService moviesService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieEntity>getMovies(){
        return MoviesService.getMovies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieEntity createMovie(@RequestBody MovieDto movieDto) {
        return moviesService.addMovie(movieDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieEntity updateMovie(@PathVariable Integer id,
                                    @RequestBody MovieDto movieDto) {
        return moviesService.putMovie(movieDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MovieEntity deleteMovie(@PathVariable Integer id) {
        moviesService.removeMovie(id);
        return null;
    }
}
