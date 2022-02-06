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

    private final ActorConverter converter;

    public MovieConverter(ActorConverter converter) {
        this.converter = converter;
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
            throw new IllegalEnumArgumentException("Incorrect enum value: " + dto.getGenre(), dto.getGenre());
        }
        movie.setActors(dto.getActorDtos() == null
                ? new HashSet<>()
                : dto.getActorDtos().stream().map(converter::convertDtoToEntity)
                .collect(Collectors.toSet()));
        return movie;
    }

    @Override
    public MovieDto convertEntityToDto(Movie entity) {
        MovieDto dto = new MovieDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setProfit(entity.getProfit());
        dto.setDuration(entity.getDuration());
        dto.setGenre(dto.getGenre());
        dto.setActorDtos(entity.getActors() == null
                ? new HashSet<>()
                : entity.getActors().stream().map(converter::convertEntityToDto)
                .collect(Collectors.toSet()));
        return dto;
    }
}
