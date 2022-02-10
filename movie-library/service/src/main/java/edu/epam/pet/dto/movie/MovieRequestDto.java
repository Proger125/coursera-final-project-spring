package edu.epam.pet.dto.movie;

import edu.epam.pet.dto.Dto;
import edu.epam.pet.dto.actor.ActorRequestDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovieRequestDto extends Dto {

    @Pattern(regexp = "[A-Z0-9][A-Za-z0-9\\s,.!?]{1,20}")
    private String name;

    @Min(1)
    private int duration;

    @Min(1)
    private BigDecimal profit;

    @Min(1900)
    private int creationYear;

    @Pattern(regexp = "[A-Za-z_]{5,15}")
    private String genre;

    private Set<ActorRequestDto> actors;
}
