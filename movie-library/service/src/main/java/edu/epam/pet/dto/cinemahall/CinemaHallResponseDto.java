package edu.epam.pet.dto.cinemahall;

import edu.epam.pet.dto.ResponseDto;
import edu.epam.pet.dto.cinema.CinemaResponseDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaHallResponseDto extends ResponseDto {

    private BigDecimal onePlaceCost;

    private CinemaResponseDto cinemaResponseDto;

    private Set<CinemaSessionResponseDto> cinemaSessionResponseDtos;
}
