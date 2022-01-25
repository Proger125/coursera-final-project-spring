package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@javax.persistence.Entity
@Table(name = "cinema_session")
public class CinemaSession{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_session_id")
    private Long id;

    private LocalDateTime sessionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="cinema_hall_id", nullable = false)
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "cinemaSession")
    @ToString.Exclude
    private Set<Place> places;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CinemaSession that = (CinemaSession) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
