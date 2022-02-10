package edu.epam.pet.dto.cinemahall;

import edu.epam.pet.dto.Dto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaHallResponseDto extends Dto {

    private int number;

    private BigDecimal onePlaceCost;

    private String cinema;

    private Set<String> sessions;
}
