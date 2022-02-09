package edu.epam.pet.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSessionDto extends Dto{

    private LocalDateTime sessionDate;

    private MovieDto movieDto;

    private CinemaHallDto cinemaHallDto;

    private Set<PlaceDto> places;
}
