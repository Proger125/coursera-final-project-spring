package edu.epam.pet.dto.cinemasession;

import edu.epam.pet.dto.RequestDto;
import edu.epam.pet.dto.cinemahall.CinemaHallRequestDto;
import edu.epam.pet.dto.movie.MovieRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSessionRequestDto extends RequestDto {

    @NotNull
    private LocalDateTime sessionDate;

    @NotNull
    private MovieRequestDto movieRequestDto;

    @NotNull
    private CinemaHallRequestDto cinemaHallRequestDto;
}
