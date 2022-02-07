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

    private BigDecimal onePlaceCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHall", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<CinemaSession> cinemaSessions;

}
