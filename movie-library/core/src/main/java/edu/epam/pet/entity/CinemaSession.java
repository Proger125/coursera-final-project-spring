package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cinema_sessions")
public class CinemaSession extends BaseEntity {

    private LocalDateTime sessionDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "cinemaSession", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Place> places;
}
