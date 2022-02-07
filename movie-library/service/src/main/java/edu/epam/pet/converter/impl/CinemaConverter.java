package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinema.CinemaRequestDto;
import edu.epam.pet.dto.cinema.CinemaResponseDto;
import edu.epam.pet.entity.Cinema;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CinemaConverter implements Converter<Cinema, CinemaRequestDto, CinemaResponseDto> {

    private final MovieConverter movieConverter;

    private final CinemaHallConverter cinemaHallConverter;

    public CinemaConverter(MovieConverter movieConverter, CinemaHallConverter cinemaHallConverter) {
        this.movieConverter = movieConverter;
        this.cinemaHallConverter = cinemaHallConverter;
    }

    @Override
    public Cinema convertDtoToEntity(CinemaRequestDto dto) {
        Cinema cinema = new Cinema();
        cinema.setName(dto.getName());
        return cinema;
    }

    @Override
    public CinemaResponseDto convertEntityToDto(Cinema entity) {
        CinemaResponseDto responseDto = new CinemaResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setName(entity.getName());
        responseDto.setCinemaHallResponseDtos(entity.getHalls().stream().map(cinemaHallConverter::convertEntityToDto).collect(Collectors.toSet()));
        responseDto.setMovieResponseDtos(entity.getMovies().stream().map(movieConverter::convertEntityToDto).collect(Collectors.toSet()));
        return responseDto;
    }
}
