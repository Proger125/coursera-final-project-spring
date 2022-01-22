package edu.epam.pet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class Movie extends Entity {
    private String name;
    private int duration;
    private BigDecimal profit;
    private int creationYear;
    private Genre genre;
    private Set<Actor> actors;
}
