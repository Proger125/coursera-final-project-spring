package edu.epam.pet.dto.movie;

import edu.epam.pet.dto.Dto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovieResponseDto extends Dto {

    private String name;

    private int duration;

    private BigDecimal profit;

    private int creationYear;

    private String genre;

    private Set<String> actors;
}
