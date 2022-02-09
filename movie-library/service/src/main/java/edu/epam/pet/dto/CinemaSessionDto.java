package edu.epam.pet.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSessionDto extends Dto{

    @NotNull
    private LocalDateTime sessionDate;

    @NotNull
    private MovieDto movieDto;

    @NotNull
    private CinemaHallDto cinemaHallDto;

    private Set<PlaceDto> places;
}
