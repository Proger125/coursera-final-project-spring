package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinemasession.CinemaSessionRequestDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import edu.epam.pet.entity.CinemaSession;
import org.springframework.stereotype.Component;

@Component
public class CinemaSessionConverter implements Converter<CinemaSession, CinemaSessionRequestDto, CinemaSessionResponseDto> {

    private final CinemaHallConverter cinemaHallConverter;

    private final MovieConverter movieConverter;

    public CinemaSessionConverter(CinemaHallConverter cinemaHallConverter, MovieConverter movieConverter) {
        this.cinemaHallConverter = cinemaHallConverter;
        this.movieConverter = movieConverter;
    }

    @Override
    public CinemaSession convertDtoToEntity(CinemaSessionRequestDto dto) {
        CinemaSession cinemaSession = new CinemaSession();
        cinemaSession.setSessionDate(dto.getSessionDate());
        cinemaSession.setCinemaHall(cinemaHallConverter.convertDtoToEntity(dto.getCinemaHallRequestDto()));
        cinemaSession.setMovie(movieConverter.convertDtoToEntity(dto.getMovieRequestDto()));
        return cinemaSession;
    }

    @Override
    public CinemaSessionResponseDto convertEntityToDto(CinemaSession entity) {
        CinemaSessionResponseDto cinemaSessionResponseDto = new CinemaSessionResponseDto();
        cinemaSessionResponseDto.setId(entity.getId());
        cinemaSessionResponseDto.setSessionDate(entity.getSessionDate());
        cinemaSessionResponseDto.setCinemaHallResponseDto(cinemaHallConverter.convertEntityToDto(entity.getCinemaHall()));
        cinemaSessionResponseDto.setMovieResponseDto(movieConverter.convertEntityToDto(entity.getMovie()));
        return cinemaSessionResponseDto;
    }
}
