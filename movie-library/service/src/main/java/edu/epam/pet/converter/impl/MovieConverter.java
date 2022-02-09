package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.MovieDto;
import edu.epam.pet.entity.Genre;
import edu.epam.pet.entity.Movie;
import edu.epam.pet.exception.converter.IllegalEnumArgumentException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class MovieConverter implements Converter<Movie, MovieDto> {

    private final ActorConverter actorConverter;

    public MovieConverter(ActorConverter actorConverter) {
        this.actorConverter = actorConverter;
    }

    @Override
    public Movie convertDtoToEntity(MovieDto dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setName(dto.getName());
        movie.setCreationYear(dto.getCreationYear());
        movie.setProfit(dto.getProfit());
        movie.setDuration(dto.getDuration());
        try {
            movie.setGenre(Genre.valueOf(dto.getGenre().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalEnumArgumentException();
        }

        movie.setActors(dto.getActors() == null
                ? new HashSet<>()
                : dto.getActors()
                .stream()
                .map(actorConverter::convertDtoToEntity)
                .collect(Collectors.toSet()));
        return movie;
    }

    @Override
    public MovieDto convertEntityToDto(Movie entity) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(entity.getId());
        movieDto.setName(entity.getName());
        movieDto.setDuration(entity.getDuration());
        movieDto.setProfit(entity.getProfit());
        movieDto.setGenre(entity.getGenre().name());
        movieDto.setActors(entity.getActors()
                .stream().map(actorConverter::convertEntityToDto)
                .collect(Collectors.toSet()));
        return movieDto;
    }
}
