package edu.epam.pet.dto.cinema;

import edu.epam.pet.dto.Dto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaResponseDto extends Dto {

    private String name;

    private Set<String> movies;

    private Set<String> cinemaHalls;
}
