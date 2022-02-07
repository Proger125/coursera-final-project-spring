package edu.epam.pet.converter.impl;

import edu.epam.pet.converter.Converter;
import edu.epam.pet.dto.cinemahall.CinemaHallRequestDto;
import edu.epam.pet.dto.cinemahall.CinemaHallResponseDto;
import edu.epam.pet.entity.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallConverter implements Converter<CinemaHall, CinemaHallRequestDto, CinemaHallResponseDto> {

    private final CinemaConverter cinemaConverter;

    public CinemaHallConverter(CinemaConverter converter) {
        this.cinemaConverter = converter;
    }

    @Override
    public CinemaHall convertDtoToEntity(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setOnePlaceCost(dto.getOnePlaceCost());
        cinemaHall.setCinema(cinemaConverter.convertDtoToEntity(dto.getCinemaRequestDto()));
        return cinemaHall;
    }

    @Override
    public CinemaHallResponseDto convertEntityToDto(CinemaHall entity) {
        CinemaHallResponseDto responseDto = new CinemaHallResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setOnePlaceCost(entity.getOnePlaceCost());
        return responseDto;
    }
}
