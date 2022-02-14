package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinemasession.CinemaSessionRequestDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import edu.epam.pet.entity.CinemaHall;
import edu.epam.pet.entity.CinemaSession;
import edu.epam.pet.entity.Movie;
import edu.epam.pet.util.ResponseGenerationUtil;
import org.springframework.stereotype.Component;

@Component
public class CinemaSessionConverter implements Converter<CinemaSession, CinemaSessionRequestDto, CinemaSessionResponseDto> {


    private final ResponseGenerationUtil responseGenerationUtil;

    public CinemaSessionConverter(ResponseGenerationUtil responseGenerationUtil) {
        this.responseGenerationUtil = responseGenerationUtil;
    }

    @Override
    public CinemaSession convertDtoToEntity(CinemaSessionRequestDto dto) {
        CinemaSession cinemaSession = new CinemaSession();
        cinemaSession.setId(dto.getId());
        cinemaSession.setSessionDate(dto.getSessionDate());
        Movie movie = new Movie();
        movie.setId(dto.getMovieId());
        cinemaSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(dto.getCinemaHallId());
        cinemaSession.setCinemaHall(cinemaHall);
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
