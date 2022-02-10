package edu.epam.pet.dto.cinemahall;

import edu.epam.pet.dto.cinema.CinemaRequestDto;
import edu.epam.pet.dto.Dto;
import edu.epam.pet.dto.cinemasession.CinemaSessionRequestDto;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaHallRequestDto extends Dto {

    @Min(1)
    private int number;

    @Min(1)
    private BigDecimal onePlaceCost;

    private CinemaRequestDto cinema;

    private Set<CinemaSessionRequestDto> sessions;
}
