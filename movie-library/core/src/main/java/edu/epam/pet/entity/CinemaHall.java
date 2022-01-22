package edu.epam.pet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaHall extends Entity{
    private BigDecimal onePlaceCost;
    private int seatsNumber;
    private Cinema cinema;
}
