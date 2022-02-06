package edu.epam.pet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovieDto extends Dto {

    @NotNull
    @Pattern(regexp = "^[A-Z0-9][a-z0-9-\\s(),.!&?]{1,30}$")
    private String name;

    @NotNull
    @Min(30)
    @Max(600)
    private int duration;

    @NotNull
    @Min(0)
    private BigDecimal profit;

    @NotNull
    @Min(1900)
    private int creationYear;

    @NotNull
    @Pattern(regexp = "^[A-Za-z_]{5,15}$")
    private String genre;

    private Set<ActorDto> actorDtos;
}
