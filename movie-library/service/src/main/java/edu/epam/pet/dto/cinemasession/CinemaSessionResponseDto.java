package edu.epam.pet.dto.cinemasession;

import edu.epam.pet.dto.ResponseDto;
import edu.epam.pet.dto.cinemahall.CinemaHallResponseDto;
import edu.epam.pet.dto.movie.MovieResponseDto;
import edu.epam.pet.dto.place.PlaceResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSessionResponseDto extends ResponseDto {

    private LocalDateTime sessionDate;

    private MovieResponseDto movieResponseDto;

    private CinemaHallResponseDto cinemaHallResponseDto;

    private Set<PlaceResponseDto> placeResponseDtos;
}
