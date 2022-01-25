package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@javax.persistence.Entity
public class Place{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    private int seatRow;

    private int seatPlace;

    private boolean isTaken;

    @ManyToOne
    @JoinColumn(name = "cinema_session_id", nullable = false)
    private CinemaSession cinemaSession;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Place place = (Place) o;
        return getId() != null && Objects.equals(getId(), place.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
