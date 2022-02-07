package edu.epam.pet.dto.movie;

import edu.epam.pet.dto.ResponseDto;
import edu.epam.pet.dto.actor.ActorResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovieResponseDto extends ResponseDto {

    private String name;

    private int duration;

    private BigDecimal profit;

    private int creationYear;

    private String genre;

    private Set<ActorResponseDto> actorDtos;
}
