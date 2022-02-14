package edu.epam.pet.dto.cinemasession;

import edu.epam.pet.dto.cinemahall.CinemaHallRequestDto;
import edu.epam.pet.dto.Dto;
import edu.epam.pet.dto.movie.MovieRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSessionRequestDto extends Dto {

    @NotNull
    private LocalDateTime sessionDate;

    @NotNull
    private Long movieId;

    @NotNull
    private Long cinemaHallId;
}
