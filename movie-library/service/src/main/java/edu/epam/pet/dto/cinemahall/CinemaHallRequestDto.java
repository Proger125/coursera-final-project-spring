package edu.epam.pet.dto.cinemahall;

import edu.epam.pet.dto.RequestDto;
import edu.epam.pet.dto.cinema.CinemaRequestDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaHallRequestDto extends RequestDto {

    @NotNull
    @Min(1)
    private BigDecimal onePlaceCost;

    @NotNull
    private CinemaRequestDto cinemaRequestDto;

}
