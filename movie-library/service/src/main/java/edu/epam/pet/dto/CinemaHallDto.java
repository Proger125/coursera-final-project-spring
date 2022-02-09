package edu.epam.pet.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaHallDto extends Dto{

    @Min(1)
    private BigDecimal onePlaceCost;

    private CinemaDto cinema;

    private Set<CinemaSessionDto> sessions;
}
