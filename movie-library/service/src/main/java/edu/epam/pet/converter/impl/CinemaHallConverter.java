package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinemahall.CinemaHallRequestDto;
import edu.epam.pet.dto.cinemahall.CinemaHallResponseDto;
import edu.epam.pet.entity.CinemaHall;
import edu.epam.pet.util.ResponseGenerationUtil;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class CinemaHallConverter implements Converter<CinemaHall, CinemaHallRequestDto, CinemaHallResponseDto> {

    private final CinemaConverter cinemaConverter;

    private final ResponseGenerationUtil responseGenerationUtil;

    public CinemaHallConverter(CinemaConverter cinemaConverter, ResponseGenerationUtil responseGenerationUtil) {
        this.cinemaConverter = cinemaConverter;
        this.responseGenerationUtil = responseGenerationUtil;
    }

    @Override
    public CinemaHall convertDtoToEntity(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(dto.getId());
        cinemaHall.setOnePlaceCost(dto.getOnePlaceCost());
        cinemaHall.setCinema(cinemaConverter.convertDtoToEntity(dto.getCinema()));
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto convertEntityToDto(CinemaHall entity) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(entity.getId());
        cinemaHallResponseDto.setNumber(entity.getNumber());
        cinemaHallResponseDto.setOnePlaceCost(entity.getOnePlaceCost());
        cinemaHallResponseDto.setCinema(responseGenerationUtil.createCinemaStringResponse(entity.getCinema()));
        cinemaHallResponseDto.setSessions(
                entity.getCinemaSessions() == null
                        ? new HashSet<>()
                        : entity.getCinemaSessions()
                        .stream()
                        .map(responseGenerationUtil::createCinemaSessionStringResponse)
                        .collect(Collectors.toSet()));
        return cinemaHallResponseDto;
    }
}
