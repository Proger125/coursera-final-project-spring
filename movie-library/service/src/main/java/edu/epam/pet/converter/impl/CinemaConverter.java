package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinema.CinemaRequestDto;
import edu.epam.pet.dto.cinema.CinemaResponseDto;
import edu.epam.pet.entity.Cinema;
import edu.epam.pet.util.ResponseGenerationUtil;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class CinemaConverter implements Converter<Cinema, CinemaRequestDto, CinemaResponseDto> {

    private final MovieConverter movieConverter;


    private final ResponseGenerationUtil responseGenerationUtil;

    public CinemaConverter(MovieConverter movieConverter, ResponseGenerationUtil responseGenerationUtil) {
        this.movieConverter = movieConverter;
        this.responseGenerationUtil = responseGenerationUtil;
    }

    @Override
    public Cinema convertDtoToEntity(CinemaRequestDto dto) {
        Cinema cinema = new Cinema();
        cinema.setId(dto.getId());
        cinema.setName(dto.getName());
        cinema.setMovies(
                dto.getMovies() == null
                ? new HashSet<>()
                : dto.getMovies().stream()
                .map(movieConverter::convertDtoToEntity)
                .collect(Collectors.toSet()));
        cinema.setHalls(new HashSet<>());
        return cinema;
    }

    @Override
    public CinemaResponseDto convertEntityToDto(Cinema entity) {
        CinemaResponseDto cinemaResponseDto = new CinemaResponseDto();
        cinemaResponseDto.setId(entity.getId());
        cinemaResponseDto.setName(entity.getName());
        cinemaResponseDto.setMovies(entity.getMovies()
                .stream()
                .map(responseGenerationUtil::createMovieStringResponse)
                .collect(Collectors.toSet()));
        cinemaResponseDto.setCinemaHalls(entity.getHalls()
                .stream()
                .map(responseGenerationUtil::createCinemaHallStringResponse)
                .collect(Collectors.toSet()));
        return cinemaResponseDto;
    }
}
