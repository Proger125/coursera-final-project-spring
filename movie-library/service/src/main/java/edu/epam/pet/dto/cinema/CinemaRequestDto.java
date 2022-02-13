package edu.epam.pet.dto.cinema;

import edu.epam.pet.dto.Dto;
import edu.epam.pet.dto.cinemahall.CinemaHallRequestDto;
import edu.epam.pet.dto.movie.MovieRequestDto;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaRequestDto extends Dto {

    @Pattern(regexp = "^[A-Z0-9][a-z0-9\\s]{1,20}$")
    private String name;

    private Set<MovieRequestDto> movies;

    private Set<CinemaHallRequestDto> halls;
}
