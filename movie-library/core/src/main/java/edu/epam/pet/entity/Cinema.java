package edu.epam.pet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cinema extends Entity{
    private Set<Movie> movies;
    private Set<CinemaHall> halls;
}
