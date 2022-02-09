package edu.epam.pet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaDto extends Dto {

    @Pattern(regexp = "^[A-Z0-9][a-z0-9\\s]{1,20}$")
    private String name;

    @NotNull
    private Set<MovieDto> movies;

    @NotNull
    private Set<CinemaHallDto> halls;
}
