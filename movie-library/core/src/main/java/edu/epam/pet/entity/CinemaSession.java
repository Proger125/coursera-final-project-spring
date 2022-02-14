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

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER,orphanRemoval = true)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    private CinemaHall cinemaHall;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cinema_session_id")
    @ToString.Exclude
    private Set<Place> places;
}
