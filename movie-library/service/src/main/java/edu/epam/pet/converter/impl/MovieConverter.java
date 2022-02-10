package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.movie.MovieRequestDto;
import edu.epam.pet.dto.movie.MovieResponseDto;
import edu.epam.pet.entity.Genre;
import edu.epam.pet.entity.Movie;
import edu.epam.pet.exception.converter.IllegalEnumArgumentException;
import edu.epam.pet.util.ResponseGenerationUtil;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class MovieConverter implements Converter<Movie, MovieRequestDto, MovieResponseDto> {

    private final ActorConverter actorConverter;

    private final ResponseGenerationUtil responseGenerationUtil;

    public MovieConverter(ActorConverter actorConverter, ResponseGenerationUtil responseGenerationUtil) {
        this.actorConverter = actorConverter;
        this.responseGenerationUtil = responseGenerationUtil;
    }

    @Override
    public Movie convertDtoToEntity(MovieRequestDto dto) {
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
    public MovieResponseDto convertEntityToDto(Movie entity) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(entity.getId());
        movieResponseDto.setName(entity.getName());
        movieResponseDto.setDuration(entity.getDuration());
        movieResponseDto.setProfit(entity.getProfit());
        movieResponseDto.setGenre(entity.getGenre().name());
        movieResponseDto.setActors(entity.getActors()
                .stream()
                .map(responseGenerationUtil::createActorStringResponse)
                .collect(Collectors.toSet()));
        return movieResponseDto;
    }
}
