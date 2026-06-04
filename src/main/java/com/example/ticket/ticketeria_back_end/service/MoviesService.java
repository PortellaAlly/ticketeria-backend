package com.example.ticket.ticketeria_back_end.service;

import com.example.ticket.ticketeria_back_end.database.model.MovieEntity;
import com.example.ticket.ticketeria_back_end.dto.MovieDto;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    private static final List<MovieEntity> MOVIES = new ArrayList<>();

    static {
                MOVIES.add(MovieEntity.builder()
                        .id(1)
                        .title("O Senhor dos Anéis: A Sociedade do Anel")
                        .sinopse("Um hobbit parte em uma jornada épica para destruir um anel poderoso e impedir que as trevas dominem a Terra-média.")
                        .img_url("https://br.web.img3.acsta.net/medias/nmedia/18/92/91/32/20224832.jpg")
                        .restrito(false)
                        .class_etaria("12")
                        .build());
                MOVIES.add(MovieEntity.builder()
                        .id(2)
                        .title("Toy Story")
                        .sinopse("Brinquedos ganham vida quando ninguém está olhando e vivem grandes aventuras no quarto de Andy.")
                        .img_url("https://upload.wikimedia.org/wikipedia/pt/a/a7/Toy_Story_1995.jpg")
                        .restrito(false)
                        .class_etaria("L")
                        .build());
                MOVIES.add(MovieEntity.builder()
                        .id(3)
                        .title("Interestelar")
                        .sinopse("Exploradores viajam por um buraco de minhoca no espaço em busca de um novo lar para a humanidade.")
                        .img_url("https://i.redd.it/zstvmu042i1c1.jpg")
                        .restrito(false)
                        .class_etaria("10")
                        .build());
                MOVIES.add(MovieEntity.builder()
                        .id(4)
                        .title("Coringa")
                        .sinopse("A origem de um comediante fracassado que mergulha na loucura e se torna um criminoso icônico de Gotham.")
                        .img_url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0ubDX1rGhvtIqG-yu01V4TQOqTevlWienUw&s")
                        .restrito(false)
                        .class_etaria("16")
                        .build());
                MOVIES.add(MovieEntity.builder()
                        .id(5)
                        .title("Vingadores: Ultimato")
                        .sinopse("Os heróis restantes se unem para reverter o estalo e restaurar o equilíbrio do universo.")
                        .img_url("https://upload.wikimedia.org/wikipedia/pt/9/9b/Avengers_Endgame.jpg")
                        .restrito(false)
                        .class_etaria("14")
                        .build());
                MOVIES.add(MovieEntity.builder()
                        .id(6)
                        .title("Clube da Luta")
                        .sinopse("Um funcionário insone forma um clube secreto de luta que evolui para algo muito mais perigoso.")
                        .img_url("https://br.web.img3.acsta.net/medias/nmedia/18/90/95/96/20122166.jpg")
                        .restrito(true)
                        .class_etaria("18")
                        .build());
    }

    public static List<MovieEntity> getMovies() {
        return new ArrayList<>(MOVIES);
    }

    public MovieEntity addMovie(MovieDto movieDto) {

        Integer Identifier = MOVIES.stream()
                .mapToInt(MovieEntity::getId)
                .max()
                .orElse(0) + 1;

        MovieEntity newMovie = MovieEntity.builder()
                .id(Identifier)
                .title(movieDto.getTitle())
                .sinopse(movieDto.getSinopse())
                .img_url(movieDto.getImg_url())
                .restrito(movieDto.isRestrito())
                .class_etaria(movieDto.getClass_etaria())
                .build();

        MOVIES.add(newMovie);

        return newMovie;
    }

    public MovieEntity putMovie(MovieDto movieDto, Integer id){

        MovieEntity movie = MOVIES.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Filme nao encontrado"));

        movie.setTitle(movieDto.getTitle());
        movie.setSinopse(movieDto.getSinopse());
        movie.setRestrito(movieDto.isRestrito());
        movie.setImg_url(movieDto.getImg_url());
        movie.setClass_etaria(movieDto.getClass_etaria());

        return movie;
    }
}
