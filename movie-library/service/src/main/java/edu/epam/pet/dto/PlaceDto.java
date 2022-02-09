package edu.epam.pet.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlaceDto extends Dto{

    private int seatRow;

    private int seatPlace;

    private boolean isTaken;

    private CinemaSessionDto cinemaSession;
}
