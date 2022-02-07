package edu.epam.pet.dto.place;

import edu.epam.pet.dto.ResponseDto;
import edu.epam.pet.dto.cinemasession.CinemaSessionResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlaceResponseDto extends ResponseDto {

    private int seatRow;

    private int seatPlace;

    private boolean isTaken;

    private CinemaSessionResponseDto cinemaSessionResponseDto;
}
