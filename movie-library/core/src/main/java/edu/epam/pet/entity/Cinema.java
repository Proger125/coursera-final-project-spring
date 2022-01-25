package edu.epam.pet.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@javax.persistence.Entity
public class Cinema{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long id;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "cinema_movie",
            joinColumns = {@JoinColumn(name = "cinema_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    @ToString.Exclude
    private Set<Movie> movies;

    @OneToMany(mappedBy = "cinema")
    @ToString.Exclude
    private Set<CinemaHall> halls;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Cinema cinema = (Cinema) o;
        return getId() != null && Objects.equals(getId(), cinema.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
