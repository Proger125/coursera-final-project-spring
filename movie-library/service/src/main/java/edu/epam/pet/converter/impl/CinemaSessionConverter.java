package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinemasession.CinemaSessionRequestDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import edu.epam.pet.entity.CinemaSession;
import edu.epam.pet.util.ResponseGenerationUtil;
import org.springframework.stereotype.Component;

@Component
public class CinemaSessionConverter implements Converter<CinemaSession, CinemaSessionRequestDto, CinemaSessionResponseDto> {

    private final MovieConverter movieConverter;

    private final CinemaHallConverter cinemaHallConverter;

    private final ResponseGenerationUtil responseGenerationUtil;

    public CinemaSessionConverter(MovieConverter movieConverter, CinemaHallConverter cinemaHallConverter, ResponseGenerationUtil responseGenerationUtil) {
        this.movieConverter = movieConverter;
        this.cinemaHallConverter = cinemaHallConverter;
        this.responseGenerationUtil = responseGenerationUtil;
    }

    @Override
    public CinemaSession convertDtoToEntity(CinemaSessionRequestDto dto) {
        CinemaSession cinemaSession = new CinemaSession();
        cinemaSession.setId(dto.getId());
        cinemaSession.setSessionDate(dto.getSessionDate());
        cinemaSession.setMovie(movieConverter.convertDtoToEntity(dto.getMovieRequestDto()));
        cinemaSession.setCinemaHall(cinemaHallConverter.convertDtoToEntity(dto.getCinemaHallRequestDto()));
        return cinemaSession;
    }

    @Override
    public CinemaSessionResponseDto convertEntityToDto(CinemaSession entity) {
        CinemaSessionResponseDto cinemaSessionResponseDto = new CinemaSessionResponseDto();
        cinemaSessionResponseDto.setId(entity.getId());
        cinemaSessionResponseDto.setSessionDate(entity.getSessionDate());
        cinemaSessionResponseDto.setMovie(responseGenerationUtil.createMovieStringResponse(entity.getMovie()));
        cinemaSessionResponseDto.setCinemaHall(responseGenerationUtil.createCinemaHallStringResponse(entity.getCinemaHall()));
        return cinemaSessionResponseDto;
    }
}
