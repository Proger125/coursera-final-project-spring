package edu.epam.pet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaSession extends Entity{
    private LocalDateTime sessionDate;
    private Movie movie;
    private CinemaHall cinemaHall;
}
