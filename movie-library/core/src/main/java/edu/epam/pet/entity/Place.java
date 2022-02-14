package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "places")
public class Place extends BaseEntity {

    private int seatRow;

    private int seatPlace;

    private boolean isTaken;

    @ManyToOne(fetch = FetchType.EAGER)
    private CinemaSession cinemaSession;
}
