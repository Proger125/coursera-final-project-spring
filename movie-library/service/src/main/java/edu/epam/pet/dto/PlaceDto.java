package edu.epam.pet.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlaceDto extends Dto{

    @Min(1)
    private int seatRow;

    @Min(1)
    private int seatPlace;

    @NotNull
    private boolean isTaken;

    @NotNull
    private CinemaSessionDto cinemaSession;
}
