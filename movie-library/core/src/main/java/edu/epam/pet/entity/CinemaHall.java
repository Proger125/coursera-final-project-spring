package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cinema_halls")
public class CinemaHall extends BaseEntity {

    private int number;

    private BigDecimal onePlaceCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Cinema cinema;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cinema_hall_id")
    @ToString.Exclude
    private Set<CinemaSession> cinemaSessions;

}
