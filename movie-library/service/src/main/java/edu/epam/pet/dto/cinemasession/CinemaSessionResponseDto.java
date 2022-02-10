package edu.epam.pet.dto.cinemasession;

import edu.epam.pet.dto.Dto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSessionResponseDto extends Dto {

    private LocalDateTime sessionDate;

    private String movie;

    private String cinemaHall;

}
