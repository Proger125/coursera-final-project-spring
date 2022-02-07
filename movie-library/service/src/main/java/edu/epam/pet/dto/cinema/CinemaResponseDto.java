package edu.epam.pet.dto.cinema;

import edu.epam.pet.dto.ResponseDto;
import edu.epam.pet.dto.cinemahall.CinemaHallResponseDto;
import edu.epam.pet.dto.movie.MovieResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaResponseDto extends ResponseDto {

    private String name;

    private Set<MovieResponseDto> movieResponseDtos;

    private Set<CinemaHallResponseDto> cinemaHallResponseDtos;
}
