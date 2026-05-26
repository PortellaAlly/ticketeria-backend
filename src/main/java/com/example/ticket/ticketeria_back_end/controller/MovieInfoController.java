package com.example.ticket.ticketeria_back_end.controller;

import com.example.ticket.ticketeria_back_end.database.model.MovieEntity;
import com.example.ticket.ticketeria_back_end.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/mvinfo")
@RequiredArgsConstructor
public class MovieInfoController {
    /*
    @PostMapping
    public ResponseEntity<String> CreateMovie(){
        return new ResponseEntity<>("teste criação", HttpStatus.CREATED);
    }
    */

    private final MoviesService moviesService;

    @GetMapping
    public List<MovieEntity>getMovies(){
        return MoviesService.getMovies();
    }
}
